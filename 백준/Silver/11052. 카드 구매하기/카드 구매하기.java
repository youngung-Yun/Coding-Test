import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
         * 카드 k를 사는데 필요한 최대 비용 =
         * 카드 0개 산 상태에서 k개 팩 사기 vs 1개 산 상태에서 k-1개 팩 사기 vs ...
         */

        int n = Integer.parseInt(br.readLine());
        int[] prices = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Integer.max(dp[i], dp[j] + prices[i-j]);
            }
        }
        System.out.println(dp[n]);
    }
}