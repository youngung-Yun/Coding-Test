
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int[][] dp = new int[a.length()+1][b.length()+1];

        for (int i = 1; i <= a.length(); i++) {
            for (int k = 1; k <= b.length(); k++) {
                if (a.charAt(i-1) == b.charAt(k-1)) {
                    dp[i][k] = dp[i-1][k-1] + 1;
                } else {
                    dp[i][k] = Integer.max(dp[i-1][k], dp[i][k-1]);
                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
}