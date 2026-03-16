import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        for (int length = 0; length < n; length++) {
            for (int start = 0; start < n - length; start++) {
                int end = start + length;
                if (length == 0) {
                    dp[start][end] = true;
                } else if (length == 1) {
                    dp[start][end] = s.charAt(start) == s.charAt(end);
                } else {
                    dp[start][end] = (s.charAt(start) == s.charAt(end)) && dp[start+1][end-1];
                }
                if (dp[start][end]) {
                    ans = Integer.max(ans, end - start + 1);
                }
            }
        }
        return ans;
    }
}