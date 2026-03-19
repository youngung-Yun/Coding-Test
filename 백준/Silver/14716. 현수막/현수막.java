import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] around = { {0, 1}, {1, 0}, {0, -1}, {-1, 0},
            {-1, -1}, {1, 1}, {-1, 1}, {1, -1} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        int[][] banner = new int[m][n];
        for (int r = 0; r < m; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                banner[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (banner[r][c] == 0 || visited[r][c]) {
                    continue;
                }
                ++count;
                bfs(banner, visited, r, c, m, n);
            }
        }
        System.out.println(count);
    }

    private static void bfs(int[][] grid, boolean[][] visited, int r, int c, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();

            for (int[] delta : around) {
                int nr = curr[0] + delta[0];
                int nc = curr[1] + delta[1];
                if (nr < 0 || nc < 0 || nr >= row || nc >= col) {
                    continue;
                }
                if (grid[nr][nc] == 0 || visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[] {nr ,nc});
            }
        }
    }
}