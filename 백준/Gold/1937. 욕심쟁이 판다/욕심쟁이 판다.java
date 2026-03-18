import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INIT = -1;
    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    static int n;
    static int[][] grid;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        n = Integer.parseInt(bf.readLine());
        grid = new int[n][n];
        dp = new int[n][n];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                grid[r][c] = Integer.parseInt(stk.nextToken());
                dp[r][c] = INIT;
            }
        }

        int ans = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                ans = Integer.max(ans, getDp(r, c));
            }
        }
        System.out.println(ans);
    }

    private static int getDp(int r, int c) {
        if (dp[r][c] != INIT) {
            return dp[r][c];
        }
        dp[r][c] = 1;
        for (int[] dir : dirs) {
            int pr = r + dir[0];
            int pc = c + dir[1];
            if (pr < 0 || pc < 0 || pr >= n || pc >= n) {
                continue;
            }
            if (grid[r][c] <= grid[pr][pc]) {
                continue;
            }

            dp[r][c] = Integer.max(dp[r][c], getDp(pr, pc) + 1);
        }
        return dp[r][c];
    }
}