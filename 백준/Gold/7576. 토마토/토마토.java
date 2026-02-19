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
        int col = Integer.parseInt(stk.nextToken());
        int row = Integer.parseInt(stk.nextToken());

        int[][] tomatoes = new int[row][col];

        Queue<int[]> queue = new ArrayDeque<>();
        int ans = 0;

        for (int r = 0; r < row; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < col; c++) {
                int object = Integer.parseInt(stk.nextToken());
                tomatoes[r][c] = object;
                if (object == 1) {
                    queue.offer(new int[] {r, c, 0});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            int r = now[0];
            int c = now[1];
            int day = now[2];
            ans = day;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (!isValid(nr, nc, row, col) || tomatoes[nr][nc] != 0) {
                    continue;
                }
                tomatoes[nr][nc] = 1;
                queue.offer(new int[] {nr, nc, day + 1});
            }
        }

        boolean isRipenAll = true;
        for (int[] r : tomatoes) {
            for (int c : r) {
                if (c == 0) {
                    isRipenAll = false;
                    break;
                }
            }
        }

        System.out.println(isRipenAll ? ans : -1);
    }

    static boolean isValid(int r, int c, int row, int col) {
        return r >= 0 && c >= 0 && r < row && c < col;
    }
}
