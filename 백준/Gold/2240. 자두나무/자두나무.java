import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int t = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());

        // dp[i][k] : i초에 k번 움직였을 때 얻을 수 있는 최대 자두 개수
        int[][] dp = new int[t][w+1];

        int first = Integer.parseInt(bf.readLine());
        if (first == 1) {
            dp[0][0] = 1;
            dp[0][1] = 0;
        } else {
            dp[0][0] = 0;
            dp[0][1] = 1;
        }

        for (int time = 1; time < t; time++) {
            int tree = Integer.parseInt(bf.readLine());
            for (int move = 0; move <= w; move++) {
                if (move == 0) {
                    dp[time][0] = dp[time-1][0];
                } else {
                    dp[time][move] = Integer.max(dp[time-1][move], dp[time-1][move-1]);
                }
                // 짝수 번 움직였으면 현재 1번 나무, 홀수 번 움직였으면 현재 2번 나무
                int curr = move % 2 == 0 ? 1 : 2;
                if (curr == tree) {
                    ++dp[time][move];
                }
            }
        }

        int ans = 0;
        for (int move = 0; move <= w; move++) {
            ans = Integer.max(ans, dp[t-1][move]);
        }
        System.out.println(ans);
    }
}
