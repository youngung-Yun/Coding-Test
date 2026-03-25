import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static long INIT = -1L;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());

            dp = new long[n+1][m+1];
            for (int i = 0; i <= n; i++) {
                for (int k = 0; k <= m; k++) {
                    dp[i][k] = INIT;
                }
            }

            long ans = 0L;
            for (int last = 1; last <= n; last++) {
                ans += getDp(last, m);
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static long getDp(int number, int order) {
        if (dp[number][order] != INIT) {
            return dp[number][order];
        }
        if (order == 1) {
            dp[number][order] = 1;
            return dp[number][order];
        }

        dp[number][order] = 0;
        for (int prev = 1; prev <= number / 2; prev++) {
            dp[number][order] += getDp(prev, order - 1);
        }
        return dp[number][order];
    }
}