import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] hall = new int[n+1][m+1];
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            hall[r][c] = 1;
        }

        int ans = 0;
        boolean[][] visited = new boolean[n+1][m+1];
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (visited[r][c] || hall[r][c] == 0) {
                    continue;
                }
                int size = 0;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[] {r, c});
                visited[r][c] = true;

                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    ++size;
                    for (int[] dir : dirs) {
                        int nr = curr[0] + dir[0];
                        int nc = curr[1] + dir[1];
                        if (nr < 1 || nc < 1 || nr > n || nc > m) {
                            continue;
                        }
                        if (hall[nr][nc] == 0 || visited[nr][nc]) {
                            continue;
                        }
                        visited[nr][nc] = true;
                        queue.offer(new int[] {nr, nc});
                    }
                }

                ans = Integer.max(ans, size);
            }
        }
        System.out.println(ans);
    }
}