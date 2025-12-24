import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = i;
            if (Math.sqrt(i) % 1.0 == 0.0) {
                dp[i] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j += ((int) Math.sqrt(j) * 2 + 1)) {
                dp[i] = Integer.min(dp[i], dp[j] + dp[i-j]);
            }
        }
        System.out.println(dp[n]);
    }
}