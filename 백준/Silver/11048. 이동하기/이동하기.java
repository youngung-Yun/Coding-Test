import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][m];
        // dp[r][c] = max(dp[r-1][c], dp[r][c-1], dp[r-1][c-1]) + maze[r][c]
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int max = 0;
                if (r > 0) {
                    max = Integer.max(max, dp[r-1][c]);
                }
                if (c > 0) {
                    max = Integer.max(max, dp[r][c-1]);
                }
                if (r > 0 && c > 0) {
                    max = Integer.max(max, dp[r-1][c-1]);
                }
                dp[r][c] = max + maze[r][c];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}

