import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] farm = new int[n][n];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                farm[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][n];
        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (farm[r][c] == 1 | visited[r][c]) {
                    continue;
                }
                int area = bfs(farm, visited, n, r, c);
                count += (int) Math.ceil(1.0 * area / k);
            }
        }

        if (count > m || count == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("POSSIBLE");
            System.out.println(m - count);
        }
    }

    private static int bfs(int[][] farm, boolean[][] visited, int n, int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            ++count;
            for (int[] dir : dirs) {
                int nr = now[0] + dir[0];
                int nc = now[1] + dir[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }
                if (farm[nr][nc] == 1 || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
        return count;
    }
}