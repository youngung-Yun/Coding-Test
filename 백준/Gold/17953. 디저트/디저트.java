import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] desserts = new int[n][m];
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            for (int k = 0; k < n; k++) {
                desserts[k][i] = Integer.parseInt(stk.nextToken());
            }
        }

        // n번째 날에 m번 디저트를 먹었을 때의 최대 만족감
        int[][] dp = new int[n][m];
        for (int d = 0; d < m; d++) {
            dp[0][d] = desserts[0][d];
        }

        for (int i = 1; i < n; i++) {
            for (int d = 0; d < m; d++) {
                int pleasure = desserts[i][d];
                for (int y = 0; y < m; y++) {
                    if (d == y) {
                        dp[i][d] = Integer.max(dp[i][d], dp[i-1][y] + (pleasure / 2));
                    } else {
                        dp[i][d] = Integer.max(dp[i][d], dp[i-1][y] + pleasure);
                    }
                }
            }
        }

        int ans = 0;
        for (int d = 0; d < m; d++) {
            ans = Integer.max(ans, dp[n-1][d]);
        }
        System.out.println(ans);
    }
}