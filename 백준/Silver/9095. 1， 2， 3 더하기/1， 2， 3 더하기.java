import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        StringBuilder sb = new StringBuilder();
        // dp[n-1]에서 1 더하는 경우
        // dp[n-2]에서 2 더하는 경우(+1+1)은 앞에서 나옴
        // dp[n-3]에서 3 더하는 경우(+1+1+1, +2+1)은 앞에서 나옴
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (dp[n] == -1) {
                for (int j = 1; j <= n; j++) {
                    int n3 = j - 3 < 0 ? 0 : dp[j - 3];
                    int n2 = j - 2 < 0 ? 0 : dp[j - 2];
                    int n1 = j - 1 < 0 ? 0 : dp[j - 1];
                    dp[j] = n1 + n2 + n3;
                }
            }
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb.toString());
    }
}