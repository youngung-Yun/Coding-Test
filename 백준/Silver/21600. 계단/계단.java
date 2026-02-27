import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] histogram = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            histogram[i] = Integer.parseInt(stk.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (histogram[i] > dp[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = histogram[i];
            }
        }

        int ans = Arrays.stream(dp).max().getAsInt();

        System.out.println(ans);
    }
}
