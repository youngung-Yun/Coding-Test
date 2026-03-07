import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] power = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            power[i] = Integer.parseInt(stk.nextToken());
        }

        // dp[k]: k번째 병사까지 생각했을 때 남아있는 병사의 최대 수
        // 0 ~ k-1 중
        // 나보다 큰 값임: dp[i] + 1
        // 나보다 작은 값임: 배치 불가능
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int prev = 0; prev <= i - 1; prev++) {
                if (power[prev] > power[i]) {
                    dp[i] = Integer.max(dp[i], dp[prev] + 1);
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();

        System.out.println(n - max);
    }
}