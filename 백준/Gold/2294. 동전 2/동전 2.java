import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = 10_001;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }

        // k원을 만드는데 필요한 최소 동전 개수
        int[] dp = new int[k+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int coin : coins) {
            for (int value = coin; value <= k; value++) {
                dp[value] = Integer.min(dp[value], dp[value-coin] + 1);
            }
        }

        System.out.println(dp[k] == INF ? -1 : dp[k]);
    }
}