import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    final static int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        // dp[day][restaurant] = 그 날에 해당 식당 가는 경우의 수
        // 0=굶음, 1~4=해당 식당 감
        int[][] dp = new int[n][5];
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }

        for (int day = 1; day < n; day++) {
            for (int restaurant = 0; restaurant < 5; restaurant++) {
                // 오늘 굶는 경우 = 어제 식당 감
                if (restaurant == 0) {
                    for (int i = 1; i < 5; i++) {
                        dp[day][restaurant] = (dp[day][restaurant] + dp[day-1][i]) % MOD;
                    }
                } else {
                // 오늘 식당 감 = 어제 굶었거나, 해당 식당 및 이웃한 식당 안감
                    dp[day][restaurant] = dp[day-1][0];
                    for (int i = 1; i < 5; i++) {
                        if (i == restaurant || i - 1 == restaurant || i + 1 == restaurant) {
                            continue;
                        }
                        dp[day][restaurant] = (dp[day][restaurant] + dp[day-1][i]) % MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[n-1][i]) % MOD;
        }

        System.out.println(ans);
    }
}
