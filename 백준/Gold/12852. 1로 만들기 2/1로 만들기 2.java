import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        int[] prev = new int[n+1];

        dp[n] = 0;
        for (int number = n; number > 1; --number) {
            if (dp[number-1] > dp[number] + 1) {
                dp[number-1] = dp[number] + 1;
                prev[number-1] = number;
            }
            if (number % 2 == 0 && dp[number/2] > dp[number] + 1) {
                dp[number/2] = dp[number] + 1;
                prev[number/2] = number;
            }
            if (number % 3 == 0 && dp[number/3] > dp[number] + 1) {
                dp[number/3] = dp[number] + 1;
                prev[number/3] = number;
            }
        }

        System.out.println(dp[1]);
        List<Integer> list = new ArrayList<>();
        int now = 1;
        while (true) {
            list.add(now);
            if(now == n) {
                break;
            } else {
                now = prev[now];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(' ');
        }
        System.out.println(sb);
    }
}
