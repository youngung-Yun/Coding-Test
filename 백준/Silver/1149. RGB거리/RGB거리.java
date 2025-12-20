import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //
        int[][] colors = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n][3];
        dp[0][0] = colors[0][0];
        dp[0][1] = colors[0][1];
        dp[0][2] = colors[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int minPrice = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j == k) {
                        continue;
                    }
                    minPrice = Math.min(minPrice, dp[i - 1][k] + colors[i][j]);
                }
                dp[i][j] = minPrice;
            }
        }
        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
    }

}
