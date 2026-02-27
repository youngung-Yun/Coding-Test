import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(stk.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }

        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int money = coin; money <= target; money++) {
                dp[money] += dp[money-coin];
            }
        }

        System.out.println(dp[target]);
    }
}
