import java.util.*;

class Solution {
    
    final static int MOD = 1_000_000_007;

    // ???
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for (int currency : money) {
            for (int m = currency; m <= n; m++) {
                dp[m] =  (dp[m] + dp[m-currency]) % MOD;;
            }
        }
        
        return dp[n];
    }
}