import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int now = 1; now < n; now++) {
            for (int prev = 0; prev < now; prev++) {
                if (arr[now] > arr[prev]) {
                    dp[now] = Integer.max(dp[now], dp[prev] + 1);
                }
            }
        }

        int ans = Arrays.stream(dp).max().getAsInt();

        System.out.println(ans);
    }
}
