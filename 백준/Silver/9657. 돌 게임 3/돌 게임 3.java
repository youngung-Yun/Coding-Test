import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[1001];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;
        // i-1, i-3, i-4중 하나라도 이기면 수가 있으면 내가 이김
        for (int i = 5; i <= n; i++) {
            if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        System.out.println(dp[n] ? "SK" : "CY");
    }
}