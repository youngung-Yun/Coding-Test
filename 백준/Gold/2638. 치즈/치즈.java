import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int[][] grid;
    static List<int[]> cheeses = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        grid = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                int value = Integer.parseInt(stk.nextToken());
                grid[r][c] = value;
                if (value == 1) {
                    cheeses.add(new int[] {r, c});
                }
            }
        }
        /*
         * 1. BFS로 치즈 아닌 공간 모두 방문
         * 2. 치즈인 공간이 주위 2면 이상이 visited 되었으면 녹음.
         * 3. 모든 치즈가 녹을 때까지 반복
         */
        int ans = 0;
        while (cheeses.size() > 0) {
            bfs();
            meltCheese();
            ++ans;
        }
        System.out.println(ans);
    }

    private static void bfs() {
        visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (grid[nx][ny] != 0 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
    }

    private static void meltCheese() {
        for (int i = 0; i < cheeses.size(); i++) {
            int x = cheeses.get(i)[0];
            int y = cheeses.get(i)[1];
            int outsideCount = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (visited[nx][ny]) {
                    ++outsideCount;
                }
            }
            if (outsideCount >= 2) {
                // 치즈 녹음
                grid[x][y] = 0;
                cheeses.remove(i);
                --i;
            }
        }
    }
}