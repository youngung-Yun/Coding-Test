import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int day = Integer.parseInt(stk.nextToken());
        int count = Integer.parseInt(stk.nextToken());

        // dp[k] : k번째 날에 준 떡 a개와 b개의 개수
        int[][] dp = new int[day+1][2];
        dp[1][0] = 1;
        dp[2][1] = 1;
        for (int d = 3; d <= day; d++) {
            dp[d] = new int[] {dp[d-1][0] + dp[d-2][0], dp[d-1][1] + dp[d-2][1]};
        }

        int[] total = dp[day];

        int a = 1;
        while (total[0] * a < count && (count - total[0] * a) % total[1] != 0) {
            ++a;
        }
        int b = (count - total[0] * a) / total[1];

        System.out.println(a);
        System.out.println(b);
    }
}
