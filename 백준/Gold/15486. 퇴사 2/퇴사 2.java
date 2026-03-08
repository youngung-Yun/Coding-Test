import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        // [start, duration, income]
        int[][] counselings = new int[n+1][2];

        for (int day = 1; day <= n; day++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int duration = Integer.parseInt(stk.nextToken());
            int income = Integer.parseInt(stk.nextToken());
            counselings[day] = new int[] {day, duration, income};
        }

        Arrays.sort(counselings, (a1, a2) -> Integer.compare(a1[0], a2[0]));

        int[] dp = new int[n+2];
        for (int day = 1; day <=n; day++) {
            int[] counseling = counselings[day];
            int start = counseling[0];
            int duration = counseling[1];
            int income = counseling[2];

            dp[start] = Integer.max(dp[start], dp[start-1]);

            int end = start + duration;

            if (end <= n+1) {
                dp[end] = Integer.max(dp[end], dp[start] + income);
            }
        }

        dp[n+1] = Integer.max(dp[n+1], dp[n]);
        System.out.println(dp[n+1]);
    }
}
