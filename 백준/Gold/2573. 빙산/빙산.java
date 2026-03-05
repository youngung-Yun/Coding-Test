import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {

    static int n;
    static int m;
    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        Queue<int[]> glacier = new ArrayDeque<>();
        int[][] map = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                int height = Integer.parseInt(stk.nextToken());
                map[r][c] = height;
                if (height > 0) {
                    glacier.offer(new int[] {r, c});
                }
            }
        }

        int ans = 0;
        int elapsed = 0;
        while (!glacier.isEmpty()) {
            ++elapsed;
            int[][] diff = new int[n][m];
            int glacierCount = glacier.size();
            while (glacierCount-- > 0) {
                int[] pos = glacier.poll();
                for (int[] dir : dirs) {
                    int dr = pos[0] + dir[0];
                    int dc = pos[1] + dir[1];
                    if (isValid(dr, dc) && map[dr][dc] == 0) {
                        --diff[pos[0]][pos[1]];
                    }
                }
                glacier.offer(pos);
            }
            glacierCount = glacier.size();
            while (glacierCount-- > 0) {
                int[] pos = glacier.poll();
                int x = pos[0];
                int y = pos[1];
                map[x][y] += diff[x][y];
                if (map[x][y] < 0) {
                    map[x][y] = 0;
                    continue;
                }
                glacier.offer(pos);
            }

            // 덩어리 개수 체크
            int count = 0;
            boolean[][] visited = new boolean[n][m];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (map[r][c] != 0 && !visited[r][c]) {
                        ++count;
                        bfs(map, visited, r, c);
                    }
                }
            }
            if (count > 1) {
                ans = elapsed;
                break;
            }
        }
        System.out.println(ans);
    }

    private static void bfs(int[][] grid, boolean[][] visited, int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {startR, startC});
        visited[startR][startC] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            for (int[] dir : dirs) {
                int nr = now[0] + dir[0];
                int nc = now[1] + dir[1];
                if (!isValid(nr, nc) || grid[nr][nc] == 0 || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}