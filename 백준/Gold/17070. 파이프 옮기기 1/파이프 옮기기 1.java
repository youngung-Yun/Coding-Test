import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[][] home = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                home[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        // 0=가로, 1=대각선, 2=세로
        int[] [][] dp = new int[3][n][n];
        dp[0][0][1] = 1;
        for (int c = 2; c < n; c++) {
            if (home[0][c] == 1) {
                continue;
            }
            dp[0][0][c] = dp[0][0][c-1];
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < n; c++) {
                if (home[r][c] == 1) {
                    continue;
                }
                dp[0][r][c] = dp[0][r][c-1] + dp[1][r][c-1];
                if (home[r-1][c] != 1 && home[r][c-1] != 1) {
                    dp[1][r][c] = dp[0][r-1][c-1] + dp[1][r-1][c-1] + dp[2][r-1][c-1];
                }
                dp[2][r][c] = dp[1][r-1][c] + dp[2][r-1][c];
            }
        }

        int ans = dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1];
        System.out.println(ans);
    }
}