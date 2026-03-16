import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(bf.readLine());
            int[] arr = new int[n];
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stk.nextToken());
            }

            int ans = getMaxSubarray(arr, n);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    private static int getMaxSubarray(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.max(dp[i-1] + arr[i], arr[i]);
            max = Integer.max(max, dp[i]);
        }

        return max;
    }
}