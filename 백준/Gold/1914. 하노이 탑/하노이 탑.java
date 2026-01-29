import java.io.*;
import java.math.BigInteger;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static BigInteger[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        dp = new BigInteger[n+1];
        dp[1] = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1].multiply(new BigInteger("2")).add(new BigInteger("1"));
        }

        sb.append(dp[n].toString()).append('\n');
        if (n <= 20) {
            recursion(n, 1, 3, 2);
        }
        System.out.println(sb);
    }

    private static void recursion(int count, int from, int to, int through) throws IOException {
        if (count == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }
        recursion(count - 1, from, through, to);
        recursion(1, from, to ,through);
        recursion(count - 1, through, to, from);
    }
}