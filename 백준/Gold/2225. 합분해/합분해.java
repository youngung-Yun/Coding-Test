import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final static int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        // k개의 수를 더해서 n이 되는 경우의 수
        int[][] dp = new int[n+1][k+1];
        Arrays.fill(dp[0], 1);

        for (int sum = 1; sum <= n; sum++) {
            for (int count = 1; count <= k; count++) {
                for (int number = 0; number <= sum; number++) {
                    dp[sum][count] = (dp[sum][count] + dp[sum-number][count-1]) % MOD;
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
