import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            long[] dp = new long[101];
            dp[1] = 1L;
            dp[2] = 1L;
            dp[3] = 1L;
            dp[4] = 2L;
            dp[5] = 2L;

            int n = Integer.parseInt(br.readLine());
            for (int i = 6; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-5];
            }
            sb.append('#').append(testCase).append(' ').append(dp[n]).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}