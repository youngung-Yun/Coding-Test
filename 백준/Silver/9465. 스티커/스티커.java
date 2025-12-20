import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int col = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][col];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < col; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][col];
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            if (col > 1) {
                dp[0][1] = dp[1][0] + stickers[0][1];
                dp[1][1] = dp[0][0] + stickers[1][1];
            }
            for (int k = 2; k < col; k++) {
                dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + stickers[0][k];
                dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + stickers[1][k];
            }

            sb.append(Math.max(dp[0][col - 1], dp[1][col - 1])).append('\n');
        }
        System.out.println(sb.toString());
    }
}
