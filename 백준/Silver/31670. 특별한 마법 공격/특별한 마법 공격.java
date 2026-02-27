import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        long[] resistance = Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        // dp[k][0] = k번째 학생 단죄하지 않음, dp[k][1] = k번째 학생 단죄
        long[][] dp = new long[n][2];

        dp[0][1] = resistance[0];
        for (int student = 1; student < n; student++) {
            dp[student][0] = dp[student-1][1];
            dp[student][1] = Long.min(dp[student-1][0], dp[student-1][1]) + resistance[student];
        }

        long ans = Long.min(dp[n-1][0], dp[n-1][1]);
        System.out.println(ans);
    }
}
