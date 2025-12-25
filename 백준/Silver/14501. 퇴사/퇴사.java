import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Counseling[] counselings = new Counseling[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            counselings[i] = new Counseling(days, pay);
        }
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                dp[i] = Integer.max(dp[i-1], dp[i]);
            }
            if (i + counselings[i].days <= n) {
                dp[i + counselings[i].days] = Integer.max(dp[i + counselings[i].days], dp[i] + counselings[i].pay);
            }
        }
        dp[n] = Integer.max(dp[n], dp[n-1]);
        System.out.println(dp[n]);
    }

    private static class Counseling {
        public int days;
        public int pay;

        public Counseling(int days, int pay) {
            this.days = days;
            this.pay = pay;
        }
    }

}
