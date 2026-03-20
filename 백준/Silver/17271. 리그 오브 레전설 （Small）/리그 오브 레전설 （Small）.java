import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] dp = new int[Integer.max(n, m)+1];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        // dp[k] = k초 동안 싸웠을 때 가능한 경우의 수
        // dp[k] = dp[k-1](k-1초동안 싸우고 A씀) + dp[k-m](k-m초동안 싸우고 B씀)
        for (int i = m; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-m]) % MOD;
        }

        System.out.println(dp[n]);
    }
}