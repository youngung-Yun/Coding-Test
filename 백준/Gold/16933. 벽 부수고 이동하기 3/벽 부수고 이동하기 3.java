import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    final static int INF = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] map = new int[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                map[r][c] = row.charAt(c) - '0';
            }
        }

        // day: 0 = 낮, 1 = 밤
        // [day][breakCount][row][col]
        int[][][][] distance = new int[2][k+1][n][m];
        for (int d = 0; d < 2; d++) {
            for (int b = 0; b <= k; b++) {
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < m; c++) {
                        distance[d][b][r][c] = INF;
                    }
                }
            }
        }

        distance[0][0][0][0] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 0, 0});

        int ans = -1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int day = now[0];
            int breakCount = now[1];
            int r = now[2];
            int c = now[3];
            if (r == n - 1 && c == m - 1) {
                ans = distance[day][breakCount][r][c];
                break;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                // 벽 아니면 그냥 지나감
                if (map[nr][nc] == 0) {
                    if (distance[(day+1)%2][breakCount][nr][nc] != INF) {
                        continue;
                    }
                    distance[(day+1)%2][breakCount][nr][nc] = distance[day][breakCount][r][c] + 1;
                    queue.offer(new int[] {(day + 1) % 2, breakCount, nr, nc});
                // 벽은 낮에만 부술 수 있음
                } else if (map[nr][nc] == 1) {
                    if (day != 0 || distance[(day+1)%2][breakCount][nr][nc] != INF || breakCount == k) {
                        continue;
                    }
                    distance[(day+1)%2][breakCount+1][nr][nc] = distance[day][breakCount][r][c] + 1;
                    queue.offer(new int[] {(day + 1) % 2, breakCount + 1, nr, nc});
                }
            }
            // 밤이면 제자리에 기다리는 경우 추가
            if (day == 1 && distance[(day+1)%2][breakCount][r][c] == INF) {
                distance[(day+1)%2][breakCount][r][c] = distance[day][breakCount][r][c] + 1;
                queue.offer(new int[] {(day + 1) % 2, breakCount, r, c});
            }
        }

        System.out.println(ans);
    }
}
