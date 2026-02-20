import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final int INIT = -1;
    private static final int INF = 1_000_000;

    private static int[] dp;
    private static Set<Integer> digits;
    private static int x;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            digits = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                int digit = Integer.parseInt(stk.nextToken());
                if (digit == 1) {
                    digits.add(i);
                }
            }
            x = Integer.parseInt(bf.readLine());
            // k를 만들 수 있다 == divisor 및 k / divisor를 만들 수 있다 or
            // k / 10을 만들 수 있고 canUse[k % 10] == true이다.
            dp = new int[x+1];
            Arrays.fill(dp, INIT);

            int ans = getDp(x);

            sb.append('#').append(testcase).append(' ')
                    .append(ans == INF ? -1 : dp[x] + 1).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static int getDp(int n) {
        if (dp[n] != INIT) {
            return dp[n];
        }

        dp[n] = INF;
        if (canMakeNumber(n)) {
            dp[n] = String.valueOf(n).length();
        }

        for (int divisor = 1; divisor * divisor <= n; divisor++) {
            if (n % divisor != 0) {
                continue;
            }
            if (getDp(n / divisor) != INF && getDp(divisor) != INF) {
                dp[n] = Integer.min(dp[n], dp[n / divisor] + dp[divisor] + 1);
            }
        }

        return dp[n];
    }

    private static boolean canMakeNumber(int n) {
        while (n > 0) {
            if (!digits.contains(n % 10)) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
