import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int number = 0;
                if (j <= i) {
                    number = Integer.parseInt(st.nextToken());
                }
                triangle[i][j] = number;
            }
        }

        int[][] dp = new int[n][n + 2];
        dp[0][1] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j - 1];
            }
        }
        System.out.println(Arrays.stream(dp[n - 1]).max().getAsInt());
    }
}
