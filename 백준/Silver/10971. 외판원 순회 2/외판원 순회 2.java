import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int ans = 1_000_000 * 10;
    static int n;
    static int[][] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        adj = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                adj[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(1, i, i, 0, visited);
            visited[i] = false;
        }

        System.out.println(ans);
    }

    static void dfs(int depth, int start, int curr, int sum, boolean[] visited) {
        // 이미 최솟값보다 작으면 종료
        if (sum > ans) {
            return;
        }
        if (depth == n) {
            // 시작한 지점으로 돌아감
            if (adj[curr][start] != 0) {
                ans = Integer.min(ans, sum + adj[curr][start]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (adj[curr][i] == 0 || visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, start, i, sum + adj[curr][i], visited);
            visited[i] = false;
        }
    }
}