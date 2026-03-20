import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[][] dp = getDp();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(bf.readLine());
            long total = 0L;
            for (int digit = 0; digit < 10; digit++) {
                total += dp[n][digit];
            }

            sb.append(total).append('\n');
        }
        System.out.println(sb);
    }

    static long[][] getDp() {
        // [i][j] : i자리수 중 j로 끝나는 경우의 수
        long[][] dp = new long[64+1][10];
        for (int digit = 0; digit < 10; digit++) {
            dp[1][digit] = 1L;
        }

        for (int i = 2; i <= 64; i++) {
            for (int digit = 0; digit < 10; digit++) {
                for (int lower = 0; lower <= digit; lower++) {
                    dp[i][digit] += dp[i-1][lower];
                }
            }
        }

        return dp;
    }
}