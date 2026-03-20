import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        int[][] grid = new int[n][m];
        for (int r = 0; r < n; r++) {
            String line = bf.readLine();
            for (int c = 0; c < m; c++) {
                int object = line.charAt(c) - '0';
                grid[r][c] = object;
                if (r == 0 && object == 0) {
                    queue.offer(new int[] {r, c});
                    visited[r][c] = true;
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
                if (grid[nr][nc] == 1 || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }

        for (int c = 0; c < m; c++) {
            if (visited[n-1][c]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}