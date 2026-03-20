import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] grid = new int[n][m];
        int[][] distance = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                distance[r][c] = -1;
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                grid[r][c] = Integer.parseInt(stk.nextToken());
                if (grid[r][c] == 1) {
                    queue.offer(new int[] {r, c});
                    distance[r][c] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                if (grid[nr][nc] == 1 || distance[nr][nc] != -1) {
                    continue;
                }
                distance[nr][nc] = distance[curr[0]][curr[1]] + 1;
                queue.offer(new int[] {nr, nc});
            }
        }

        int max = 0;
        for (int[] row : distance) {
            for (int col : row) {
                max = Integer.max(max, col);
            }
        }
        System.out.println(max);
    }
}