import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[][] dp = new long[2][n];
        dp[0][0] = sequence[0];
        dp[1][0] = -sequence[0];
        
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                dp[0][i] = sequence[i];
                dp[1][i] = -sequence[i];
            } else {
                dp[0][i] = -sequence[i];
                dp[1][i] = sequence[i];
            }
            dp[0][i] = Long.max(dp[0][i], dp[0][i-1] + dp[0][i]);
            dp[1][i] = Long.max(dp[1][i], dp[1][i-1] + dp[1][i]);
        }
        
        long ans = dp[0][0];
        for (int i = 0; i < n; i++) {
            ans = Long.max(ans, Long.max(dp[0][i], dp[1][i]));
        }
        return ans;
    }
}