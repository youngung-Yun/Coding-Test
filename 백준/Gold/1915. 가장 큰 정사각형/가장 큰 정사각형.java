import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] grid = new int[n][m];
        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                grid[r][c] = row.charAt(c) - '0';
            }
        }

        int width = 0;
        int[][] dp = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (r == 0 || c == 0) {
                    dp[r][c] = grid[r][c];
                } else {
                    if (grid[r][c] == 0) {
                        dp[r][c] = 0;
                    } else {
                        dp[r][c] = Integer.min(Integer.min(dp[r-1][c], dp[r][c-1]), dp[r-1][c-1]) + 1;
                    }
                }
                width = Integer.max(width, dp[r][c]);
            }
        }

        System.out.println(width * width);
    }
}