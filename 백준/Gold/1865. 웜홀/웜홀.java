import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<int[]> edges = new ArrayList<>();
    final static int INF = 500 * 10_000 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 0; testcase < t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());

            // [src, dest, cost]
            edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                stk = new StringTokenizer(bf.readLine());
                int src = Integer.parseInt(stk.nextToken());
                int dest = Integer.parseInt(stk.nextToken());
                int cost = Integer.parseInt(stk.nextToken());
                edges.add(new int[] {src, dest, cost});
                edges.add(new int[] {dest, src, cost});
            }

            List<Integer> startpoint = new ArrayList<>();
            for (int i = 0; i < w; i++) {
                stk = new StringTokenizer(bf.readLine());
                int src = Integer.parseInt(stk.nextToken());
                int dest = Integer.parseInt(stk.nextToken());
                int cost = Integer.parseInt(stk.nextToken());
                edges.add(new int[] {src, dest, -cost});
                startpoint.add(src);
            }

            boolean hasCycle = false;
            for (int start : startpoint) {
                hasCycle = checkHasCycle(start);
                if (hasCycle) {
                    break;
                }
            }

            System.out.println(hasCycle ? "YES" : "NO");
        }
    }

    private static boolean checkHasCycle(int start) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int src = edge[0];
                int dest = edge[1];
                int cost = edge[2];
                if (distance[src] == INF) {
                    continue;
                }
                distance[dest] = Integer.min(distance[dest], distance[src] + cost);
            }
        }

        // 음수 사이클 체크
        boolean hasCycle = false;
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];
            if (distance[src] == INF) {
                continue;
            }
            if (distance[dest] > distance[src] + cost) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }
}
