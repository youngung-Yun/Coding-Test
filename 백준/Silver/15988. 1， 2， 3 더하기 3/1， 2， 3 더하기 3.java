import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];

        StringBuilder sb = new StringBuilder();
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            if (dp[n] == 0) {
                for (int i = 3; i <= n; i++) {
                    dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1_000_000_009;
                }
            }
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
