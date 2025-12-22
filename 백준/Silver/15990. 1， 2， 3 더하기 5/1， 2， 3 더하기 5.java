import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static long MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[100_001][3];
        dp[0][0] = 1L;
        dp[1][0] = 1L;
        dp[2][1] = 1L;
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            if (dp[n][0] == 0L && dp[n][1] == 0L && dp[n][2] == 0L) {
                for (int i = 3; i <= n; i++) {
                    dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % MOD;
                    dp[i][1] = (dp[i-2][0] + dp[i-2][2]) % MOD;
                    dp[i][2] = (dp[i-3][0] + dp[i-3][1]) % MOD;
                }
            }
            long result = 0L;
            for (long e : dp[n]) {
                result = (result + e) % MOD;
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb.toString());
    }
}