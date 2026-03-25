import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static long INIT = -1L;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());

            // m개의 숫자를 골랐을 때 최대값이 n 이하인 경우의 수
            // n-1에서 m개를 다 골랐을 경우 + n/2에서 m-1개를 골랐을 경우
            dp = new long[m+1][n+1];
            Arrays.fill(dp[0], 1);
            for (int i = 1; i <= m; i++) {
                for (int k = 1; k <= n; k++) {
                    dp[i][k] = INIT;
                }
            }

            long ans = getDp(m, n);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static long getDp(int count, int number) {
        if (dp[count][number] != INIT) {
            return dp[count][number];
        }
        if (number <= 0) {
            return 0;
        }

        dp[count][number] = getDp(count, number - 1) + getDp(count - 1, number / 2);
        return dp[count][number];
    }
}