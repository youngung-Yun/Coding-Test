import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /*
         * dp[i - 1] > max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i])면 i번째는 안마시는게 이득
         */

        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = wines[1];
        if (n > 1) {
            dp[2] = wines[1] + wines[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + wines[i - 1]) + wines[i]);
        }

        System.out.println(dp[n]);
    }
}
