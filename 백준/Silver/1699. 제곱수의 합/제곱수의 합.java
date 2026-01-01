import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // dp[n] = 1<=k^2<=n인 k중 dp[n-k^2]의 최솟값 + 1
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int k = 1; k * k <= i; k++) {
                dp[i] = Integer.min(dp[i], dp[i-k*k] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}

