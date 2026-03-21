import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(bf.readLine());

        long sum = 0L;
        for (int i = 0; i < m; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            // n면체
            long n = Long.parseLong(stk.nextToken());
            // 합이 s
            long s = Long.parseLong(stk.nextToken());

            long gcd = getGcd(Long.max(n, s), Long.min(n, s));

            long a = s / gcd;
            long b = n / gcd;

            long bInv = getModuloInv(b);

            long result = (a * bInv) % MOD;
            sum = (sum + result) % MOD;
        }
        System.out.println(sum);
    }

    private static long getGcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }

    private static long getModuloInv(long num) {
        // b^(X-2) % X = bInv
        return getPower(num, MOD - 2) % MOD;
    }

    private static long getPower(long a, long exp) {
        if (exp == 1L) {
            return a;
        }

        long halfPower = getPower(a, exp / 2L) % MOD;
        long result = (halfPower * halfPower) % MOD;
        if (exp % 2L == 1L) {
            result = (result * a) % MOD;
        }
        return result;
    }
}