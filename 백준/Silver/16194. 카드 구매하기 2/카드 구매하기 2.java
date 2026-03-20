import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final static int MAX = 10_000 * 1_000 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] packs = new int[n+1];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            packs[i] = Integer.parseInt(stk.nextToken());
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        // 카드를 k개 사는 최솟값 = min(1개 사놓고 k-1개짜리 사기, 2개 사놓고 k-2개짜리 사기, ... k-1개 사놓고 1개짜리 사기)
        for (int i = 1; i <= n; i++) {
            for (int count = i; count <= n; count++) {
                dp[count] = Integer.min(dp[count], dp[count-i] + packs[i]);
            }
        }
        System.out.println(dp[n]);
    }
}