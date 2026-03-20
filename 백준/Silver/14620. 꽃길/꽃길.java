import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final static int[][] dirs = { {0, 0}, {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

    static int n;
    static int[][] pay;
    static int ans = 15 * 200;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        n = Integer.parseInt(bf.readLine());
        pay = new int[n][n];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                pay[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        boolean[][] flowerbed = new boolean[n][n];
        backtracking(flowerbed, 0, 0);
        System.out.println(ans);
    }

    static void backtracking(boolean[][] visited, int depth, int total) {
        if (depth == 3) {
            ans = Integer.min(ans, total);
            return;
        }

        for (int r = 1; r < n - 1; r++) {
            for (int c = 1; c < n - 1; c++) {

                boolean canPlant = true;
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    canPlant &= !(visited[nr][nc]);
                }
                if (!canPlant) {
                    continue;
                }

                int sum = 0;
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    sum += pay[nr][nc];
                    visited[nr][nc] = true;
                }

                backtracking(visited, depth + 1, total + sum);

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    visited[nr][nc] = false;
                }
            }
        }
    }
}