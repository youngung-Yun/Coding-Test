import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] shops;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        dp = new int[n];

        shops = new int[n];
        int[] last = new int[3];
        boolean isFirst = true;
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int milk = Integer.parseInt(stk.nextToken());
            shops[i] = milk;
            last[milk] = i;
            if (milk == 0 && isFirst) {
                dp[i] = 1;
                isFirst = false;
            }
        }

        for (int shop = 0; shop < n; shop++) {
            int prevMilk = (shops[shop] + 2) % 3;
            for (int prev = 0; prev < shop; prev++) {
                if (shops[prev] == prevMilk && dp[prev] != 0) {
                    dp[shop] = Integer.max(dp[shop], dp[prev] + 1);
                }
            }
        }

        int ans = Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);
    }
}