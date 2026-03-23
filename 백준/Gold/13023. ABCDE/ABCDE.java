import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean ans = false;
    static List<List<Integer>> adj;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        ans = false;
        visited = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            backtrack(i, 1);
            visited[i] = false;
            if (ans) {
                break;
            }
        }
        System.out.println(ans ? 1 : 0);
    }

    static void backtrack(int curr, int depth) {
        if (depth >= 5) {
            ans = true;
        }
        if (ans) {
            return;
        }

        for (int next : adj.get(curr)) {
            if (visited[next]) {
                continue;
            }

            visited[next] = true;
            backtrack(next, depth + 1);
            visited[next] = false;
        }
    }
}