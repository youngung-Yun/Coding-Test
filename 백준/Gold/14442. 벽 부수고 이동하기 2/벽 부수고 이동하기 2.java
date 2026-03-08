import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    final static int NEVER = 1_000 * 1_000 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] map = new int[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++)
                map[r][c] = row.charAt(c) - '0';
        }

        int[][][] distance = new int[n][m][k+1];
        for (int[][] row : distance) {
            for (int[] col : row) {
                Arrays.fill(col, NEVER);
            }
        }

        distance[0][0][0] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 0});

        int ans = -1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int breakCount = now[2];

            if (r == n - 1 && c == m - 1) {
                ans = distance[r][c][breakCount];
                break;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                // 더 이상 벽 못부숨
                if (map[nr][nc] == 1 && breakCount == k) {
                    continue;
                }

                if (map[nr][nc] == 0) {
                    if (distance[nr][nc][breakCount] != NEVER) {
                        continue;
                    }
                    distance[nr][nc][breakCount] = distance[r][c][breakCount] + 1;
                    queue.offer(new int[] {nr, nc, breakCount});
                } else {
                    if (distance[nr][nc][breakCount+1] != NEVER) {
                        continue;
                    }
                    distance[nr][nc][breakCount+1] = distance[r][c][breakCount] + 1;
                    queue.offer(new int[] {nr,  nc, breakCount + 1});
                }
            }
        }

        System.out.println(ans);
    }
}
