import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 북, 동, 남, 서
    final static int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());
        int dir = Integer.parseInt(stk.nextToken());

        int[][] places = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                places[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        int ans = 0;
        boolean canMove = true;
        while (canMove) {
            // 청소
            if (places[x][y] != -1) {
                places[x][y] = -1;
                ++ans;
            }

            // 청소 안된 칸 없음
            if (!existDirtyPlace(places, x, y)) {
                int nx = x - dirs[dir][0];
                int ny = y - dirs[dir][1];
                // 후진 불가능
                if (!isValid(nx, ny) || places[nx][ny] == 1) {
                    canMove = false;
                    break;
                }
                // 후진 가능
                x = nx;
                y = ny;
                continue;
            }

            dir = (dir + 3) % 4;
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];

            if (isValid(nx, ny) && places[nx][ny] == 0) {
                x = nx;
                y = ny;
            }
        }

        System.out.println(ans);
    }

    private static boolean existDirtyPlace(int[][] grid, int x, int y) {
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (!isValid(nx, ny)) {
                continue;
            }
            if (grid[nx][ny] == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
