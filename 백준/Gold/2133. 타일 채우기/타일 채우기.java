import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] dp = new int[31];
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            dp[i] = 3 * dp[i-2];
            for (int left = 4; left <= i; left += 2) {
                dp[i] += dp[i-left] * 2;
            }
        }

        System.out.println(dp[n]);
    }
}
