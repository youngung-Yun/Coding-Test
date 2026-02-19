import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    final static int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            int n = Integer.parseInt(bf.readLine());
            int ans = 0;

            int[][] cheese = new int[n][n];

            for (int r = 0; r < n; r++) {
                StringTokenizer stk = new StringTokenizer(bf.readLine());
                for (int c = 0; c < n; c++) {
                    cheese[r][c] = Integer.parseInt(stk.nextToken());
                }
            }

            for (int day = 0; day <= 100; day++) {
                int count = 0;
                boolean[][] visited = new boolean[n][n];
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (visited[r][c] || cheese[r][c] <= day) {
                            continue;
                        }
                        ++count;
                        bfs(cheese, visited, r, c, n, day);
                    }
                }
                ans = Integer.max(ans, count);
            }
            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int[][] grid, boolean[][] visited, int sr, int sc, int n, int day) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            int r = now[0];
            int c = now[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (!isValid(nr, nc, n) || visited[nr][nc] || grid[nr][nc] <= day) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
    }

    static boolean isValid(int r, int c, int n) {
        return r >= 0 &&  c >= 0 && r < n && c < n;
    }
}
