import java.util.*;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        // 0=위에서 아래, 1=왼쪽에서 오른쪽
        int[] [][] dp = new int [2][m][n];
        
        dp[0][0][0] = 1;
        dp[1][0][0] = 1;
        for (int r = 1; r < m; r++) {
            if (cityMap[r][0] == 1) {
                continue;
            }
            dp[0][r][0] = dp[0][r-1][0];
        }
        for (int c = 1; c < n; c++) {
            if (cityMap[0][c] == 1) {
                continue;
            }
            dp[1][0][c] = dp[1][0][c-1];
        }
        
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (cityMap[r][c] == 1) {
                    continue;
                }
                if (cityMap[r-1][c] == 2) {
                    dp[0][r][c] = dp[0][r-1][c];
                } else {
                    dp[0][r][c] = (dp[0][r-1][c] + dp[1][r-1][c]) % MOD;
                }
                if (cityMap[r][c-1] == 2) {
                    dp[1][r][c] = dp[1][r][c-1];
                } else {
                    dp[1][r][c] = (dp[0][r][c-1] + dp[1][r][c-1]) % MOD;
                }
            }
        }
        return (dp[0][m-1][n-1] + dp[1][m-1][n-1]) % MOD;
    }
}