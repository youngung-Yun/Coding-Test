import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int talent = Integer.parseInt(stk.nextToken());
            int p = Integer.parseInt(stk.nextToken());

            // dp[i][p] = i 달란트로 p개 묶음 만들었을 때 최댓값
            // dp[i][p] = max(dp[i-a][p-b] * dp[a][b]) (1 <= a < i, b >= 1)
            long[][] dp = new long[talent+1][p+1];

            for (int i = 1; i <= talent; i++) {
                dp[i][1] = i;
            }

            for (int i = 2; i <= talent; i++) {
                for (int k = 2; k <= p; k++) {
                    for (int a = 1; a < i; a++) {
                        for (int b = 1; b < k; b++) {
                            dp[i][k] = Long.max(dp[i][k], dp[i-a][k-b] * dp[a][b]);
                        }
                    }
                }
            }

            sb.append('#').append(tc).append(' ')
                    .append(dp[talent][p]).append('\n');
        }
        System.out.println(sb);
    }
}