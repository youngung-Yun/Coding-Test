import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        
        int[][] route = new int[n][m];
        for (int[] puddle : puddles) {
            int r = puddle[1] - 1;
            int c = puddle[0] - 1;
            route[r][c] = 1;
        }
        
        int[][] dp = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (route[r][c] == 1) {
                    continue;
                }
                if (r == 0 && c == 0) {
                    dp[r][c] = 1;
                }
                else if (r == 0) {
                    dp[r][c] = dp[r][c-1];
                } else if (c == 0) {
                    dp[r][c] = dp[r-1][c];
                } else {
                    dp[r][c] = (dp[r-1][c] + dp[r][c-1]) % MOD;
                }
            }
        }
        return dp[n-1][m-1];
    }
}