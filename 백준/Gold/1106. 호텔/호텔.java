import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final static int MAX = 1_000 * 2 * 100 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int c = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        // [pay, client]
        int[][] cities = new int[n][2];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            int pay = Integer.parseInt(stk.nextToken());
            int client = Integer.parseInt(stk.nextToken());
            cities[i][0] = pay;
            cities[i][1] = client;
        }

        // dp[k] : 고객을 k명 만드는데 필요한 최소 비용
        int[] dp = new int[c+101];
        Arrays.fill(dp,MAX);
        dp[0] = 0;
        for (int[] city : cities) {
            int pay = city[0];
            int client = city[1];

            for (int i = client; i <= c + 100; i++) {
                if (i - client == MAX) {
                    continue;
                }
                dp[i] = Integer.min(dp[i], dp[i-client] + pay);
            }
        }

        int ans = dp[c];
        for (int i = c; i <= c + 100; i++) {
            ans = Integer.min(ans, dp[i]);
        }
        System.out.println(ans);
    }
}