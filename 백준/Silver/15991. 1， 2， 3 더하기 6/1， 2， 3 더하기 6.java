import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    final static int MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[100_001];
        dp[0] = dp[1] = 1;
        dp[2] = dp[3] = 2;
        for (int num = 4; num <= 100_000; num++) {
            for (int d = 2; d <= 6; d += 2) {
                if (num < d) {
                    break;
                }
                dp[num] = (dp[num] + dp[num-d]) % MOD;
            }
        }

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(bf.readLine());
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
    }

}