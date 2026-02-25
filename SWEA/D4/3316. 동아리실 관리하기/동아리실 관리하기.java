import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    final static int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            String responsible = bf.readLine();
            int n = responsible.length();

            // n일차에서 해당 참여자 조합의 경우의 수
            int[][] dp = new int[n + 1][0b1 << 4];

            int first = 0b1 << (responsible.charAt(0) - 'A');
            for (int p = 1; p < (0b1 << 4); p++) {
                if ((p & first) == 0) {
                    continue;
                }
                if ((p & 0b1) == 0) {
                    continue;
                }
                dp[1][p] = 1;
            }

            for (int day = 2; day <= n; day++) {
                int todayResponsible = 0b1 << (responsible.charAt(day - 1) - 'A');
                for (int today = 1; today < (0b1 << 4); today++) {
                    for (int yesterday = 1; yesterday  < (0b1 << 4); yesterday++) {
                        // 전날 사람이 한 명도 포함안됨
                        if ((today & yesterday) == 0) {
                            continue;
                        }
                        // 책임자가 없음
                        if ((today & todayResponsible) == 0) {
                            continue;
                        }
                        dp[day][today] = (dp[day][today] + dp[day-1][yesterday]) % MOD;
                    }
                }
            }

            int ans = 0;
            for (int p = 1; p < (0b1 << 4); p++) {
                ans = (ans + dp[n][p]) % MOD;
            }
            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}