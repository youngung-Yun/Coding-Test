import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int row = 0; row < n; ++row) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; ++col) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                int distance = board[row][col];
                if (distance == 0) {
                    continue;
                }
                if (row + distance < n) {
                    dp[row + distance][col] += dp[row][col];
                }
                if (col + distance < n) {
                    dp[row][col + distance] += dp[row][col];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}