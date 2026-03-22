import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    final static int MOD = 1_234_567;
    final static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        preprocessing();

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(bf.readLine());

            // i번째 자리에 k가 오는 경우의 수
            int[][] dp = new int[n+1][10];
            for (int i = 0; i < 10; i++) {
                dp[1][i] = 1;
            }

            for (int digit = 1; digit <= n; digit++) {
                for (int number = 0; number < 10; number++) {
                    for (int prev : list.get(number)) {
                        dp[digit][number] = (dp[digit][number] + dp[digit-1][prev]) % MOD;
                    }
                }
            }

            int ans = 0;
            for (int number = 0; number < 10; number++) {
                ans = (ans + dp[n][number]) % MOD;
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void preprocessing() {
        list.add(new ArrayList<>(Arrays.asList(7)));
        list.add(new ArrayList<>(Arrays.asList(2, 4)));
        list.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
        list.add(new ArrayList<>(Arrays.asList(2, 6)));
        list.add(new ArrayList<>(Arrays.asList(1, 5, 7)));
        list.add(new ArrayList<>(Arrays.asList(2, 4, 6, 8)));
        list.add(new ArrayList<>(Arrays.asList(3, 5, 9)));
        list.add(new ArrayList<>(Arrays.asList(0, 4, 8)));
        list.add(new ArrayList<>(Arrays.asList(5, 7, 9)));
        list.add(new ArrayList<>(Arrays.asList(6, 8)));
    }
}