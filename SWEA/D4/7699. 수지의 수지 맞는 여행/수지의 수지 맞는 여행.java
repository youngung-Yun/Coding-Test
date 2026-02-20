import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    private static int ans;
    private static char[][] island;
    private static int n;
    private static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            ans = 0;
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());

            island = new char[n][m];
            for (int i = 0; i < n; i++) {
                String row = bf.readLine();
                for (int j = 0; j < m; j++) {
                    island[i][j] = row.charAt(j);
                }
            }

            boolean[] visited = new boolean[26];
            visited[island[0][0] - 'A'] = true;
            dfs(0, 0, 1, visited);

            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int r, int c, int depth, boolean[] visited) {
        ans = Integer.max(ans, depth);

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (!isValid(nr, nc, n, m) || visited[island[nr][nc] - 'A']) {
                continue;
            }
            visited[island[nr][nc] - 'A'] = true;
            dfs(nr, nc, depth + 1, visited);
            visited[island[nr][nc] - 'A'] = false;
        }
    }

    private static boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
