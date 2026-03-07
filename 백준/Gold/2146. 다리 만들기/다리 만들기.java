import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dr = {0, 0, 1, -1};
    final static int[] dc = {1, -1, 0, 0};

    static int n;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        // 섬 분류
        classifyIslands();

        int ans = n * n;
        // 각 땅에 대해 bfs
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] != 0) {
                    int minDistance = bfs(r, c);
                    ans = Integer.min(ans, minDistance);
                }
            }
        }

        System.out.println(ans);
    }

    private static void classifyIslands() {
        int island = 1;
        boolean[][] visited = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] != 0 && !visited[r][c]) {
                    ++island;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[] {r, c});
                    map[r][c] = island;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nr = curr[0] + dr[d];
                            int nc = curr[1] + dc[d];
                            if (!isValid(nr, nc) || visited[nr][nc] || map[nr][nc] == 0) {
                                continue;
                            }
                            visited[nr][nc] = true;
                            map[nr][nc] = island;
                            queue.offer(new int[] {nr, nc});
                        }
                    }
                }
            }
        }
    }

    private static int bfs(int r, int c) {
        int island = map[r][c];
        boolean[][] visited = new boolean[n][n];
        // [r, c, d]
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c, 0});

        int minDistance = n * n;
        while (!queue.isEmpty() && minDistance == n * n) {
            int[] curr = queue.poll();
            int cr = curr[0];
            int cc = curr[1];
            int cd = curr[2];
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if (!isValid(nr, nc)) {
                    continue;
                }
                // 바다
                if (map[nr][nc] == 0) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.offer(new int[] {nr, nc, cd + 1});
                    }
                // 다른 섬에 도착
                } else if (map[nr][nc] != island) {
                    minDistance = cd;
                    break;
                }
            }
        }

        return minDistance;
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}