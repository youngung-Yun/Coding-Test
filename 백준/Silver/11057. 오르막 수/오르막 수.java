import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                int sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum = (sum + dp[i-1][k]) % 10_007;
                }
                dp[i][j] = sum;
            }
        }
        int result = 0;
        for (int e : dp[n]) {
            result = (result + e) % 10_007;
        }
        System.out.println(result);
    }
}