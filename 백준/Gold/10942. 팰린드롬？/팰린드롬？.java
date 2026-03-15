import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INIT = -1;

    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n+1];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp = new int[n+1][n+1];
        for (int[] outer : dp) {
            Arrays.fill(outer, INIT);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(bf.readLine());
        for (int q = 0; q < m; q++) {
            stk = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            sb.append(getDp(s, e)).append('\n');
        }
        System.out.println(sb);
    }

    private static int getDp(int s, int e) {
        if (s > e) {
            return 1;
        }
        if (dp[s][e] != INIT) {
            return dp[s][e];
        }
        if (s == e) {
            dp[s][e] = 1;
        } else {
            if (getDp(s + 1, e - 1) == 1 && arr[s] == arr[e]) {
                dp[s][e] = 1;
            } else {
                dp[s][e] = 0;
            }
        }
        return dp[s][e];
    }
}