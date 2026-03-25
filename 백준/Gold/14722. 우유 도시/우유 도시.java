import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] map = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        int[][] [] dp = new int[n][n][3];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] == 0) {
                    dp[r][c][0] = 1;
                }
            }
        }

        for (int r = 1; r < n; r++) {
            for (int m = 0; m < 3; m++) {
                dp[r][0][m] = Integer.max(dp[r][0][m], dp[r-1][0][m]);
                int prev = (m + 2) % 3;
                if (map[r][0] == m && dp[r-1][0][prev] != 0) {
                    dp[r][0][m] = dp[r-1][0][prev] + 1;
                }
            }
        }
        for (int c = 1; c < n; c++) {
            for (int m = 0; m < 3; m++) {
                dp[0][c][m] = Integer.max(dp[0][c][m], dp[0][c-1][m]);
                int prev = (m + 2) % 3;
                if (map[0][c] == m && dp[0][c-1][prev] != 0) {
                    dp[0][c][m] = dp[0][c-1][prev] + 1;
                }
            }
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < n; c++) {
                for (int m = 0; m < 3; m++) {
                    dp[r][c][m] = Integer.max(dp[r][c][m], Integer.max(dp[r-1][c][m], dp[r][c-1][m]));
                    if (map[r][c] == m) {
                        int prev = (m + 2) % 3;
                        int max = Integer.max(dp[r-1][c][prev], dp[r][c-1][prev]);
                        if (max != 0) {
                            dp[r][c][m] = max + 1;
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int m = 0; m < 3; m++) {
            ans = Integer.max(ans, dp[n-1][n-1][m]);
        }
        System.out.println(ans);
    }
}