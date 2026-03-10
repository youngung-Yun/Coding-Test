import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = 200 * 1_000 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] adj = new int[n+1][n+1];
        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= n; c++) {
                if (r == c) {
                    adj[r][c] = 0;
                } else {
                    adj[r][c] = INF;
                }
            }
        }

        for (int path = 0; path < m; path++) {
            stk = new StringTokenizer(bf.readLine());
            int departure = Integer.parseInt(stk.nextToken());
            int arrive = Integer.parseInt(stk.nextToken());
            int time = Integer.parseInt(stk.nextToken());
            adj[departure][arrive] = time;
        }

        // 플로이드 워셜
        for (int through = 1; through <= n; through++) {
            for (int departure = 1; departure <= n; departure++) {
                for (int arrive = 1; arrive <= n; arrive++) {
                    adj[departure][arrive] = Integer.min(adj[departure][arrive], adj[departure][through] + adj[through][arrive]);
                }
            }
        }

        int k = Integer.parseInt(bf.readLine());
        int[] friends = new int[k];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < k; i++) {
            friends[i] = Integer.parseInt(stk.nextToken());
        }

        int minTime = INF;
        List<Integer> ans = new ArrayList<>();
        for (int city = 1; city <= n; city++) {
            int maxTime = 0;
            boolean canRoundTrip = true;
            for (int friend : friends) {
                // 왕복 불가능
                if (adj[friend][city] == INF || adj[city][friend] == INF) {
                    canRoundTrip = false;
                    break;
                } else {
                    maxTime = Integer.max(maxTime, adj[friend][city] + adj[city][friend]);
                }
            }
            if (canRoundTrip) {
                if (minTime > maxTime) {
                    minTime = maxTime;
                    ans.clear();
                    ans.add(city);
                } else if (minTime == maxTime) {
                    ans.add(city);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int city : ans) {
            sb.append(city).append(' ');
        }
        System.out.println(sb);
    }
}
