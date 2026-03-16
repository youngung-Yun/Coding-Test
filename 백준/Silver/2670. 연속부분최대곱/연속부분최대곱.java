import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        double ans = 0.0;
        double[] dp = new double[n];
        for (int i = 0; i < n; i++) {
            double number = Double.parseDouble(bf.readLine());
            if (i == 0) {
                dp[i] = number;
                ans = number;
            } else {
                dp[i] = Double.max(dp[i-1] * number, number);
                ans = Double.max(ans, dp[i]);
            }
        }

        System.out.println(String.format("%.3f", ans));
    }
}