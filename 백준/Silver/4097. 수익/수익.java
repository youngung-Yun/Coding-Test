import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(bf.readLine());
            if (n == 0) {
                break;
            }
            int[] dp = new int[n];
            dp[0] = Integer.parseInt(bf.readLine());
            int ans = dp[0];

            for (int i = 1; i < n; i++) {
                int income = Integer.parseInt(bf.readLine());
                dp[i] = Integer.max(dp[i-1] + income, income);
                ans = Integer.max(ans, dp[i]);
            }

            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}