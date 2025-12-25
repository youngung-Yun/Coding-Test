import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // index = n + 1_000_000;
        long[] dp = new long[2_000_001];
        StringBuilder sb = new StringBuilder();
        dp[getIndex(0)] = 0;
        dp[getIndex(1)] = 1;
        int n = Integer.parseInt(br.readLine());
        if (n > 0) {
            for (int i = 2; i <= n; i++) {
                int realIndex = getIndex(i);
                dp[realIndex] = (dp[realIndex - 1] + dp[realIndex - 2]) % 1_000_000_000;
            }
        } else if (n < 0) {
            for (int i = -1; i >= n; --i) {
                int realIndex = getIndex(i);
                dp[realIndex] = (dp[realIndex + 2] - dp[realIndex + 1]) % 1_000_000_000;
            }
        }
        long result = dp[getIndex(n)];
        if (result == 0) {
            sb.append(0);
        } else if (result > 0) {
            sb.append(1);
        } else {
            sb.append(-1);
        }
        sb.append('\n');
        sb.append(Math.abs(result));
        System.out.println(sb.toString());
    }

    private static int getIndex(int n) {
        return n + 1_000_000;
    }
}
