import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        long n = Integer.parseInt(stk.nextToken());
        long k = Integer.parseInt(stk.nextToken());

        long min = Long.min(k, n - k);
        long max = Long.max(k, n - k);

        long a = 1L;
        for (long i = max + 1L; i <= n; i++) {
            a = (a * i) % MOD;
        }

        long b = 1L;
        for (long i = 1L; i <= min; i++) {
            b = (b * i) % MOD;
        }

        long bInv = getPower(b, MOD - 2L);

        long ans = (a * bInv) % MOD;

        System.out.println(ans);
    }

    static long getPower(long num, long exp) {
        if (exp == 1L) {
            return num;
        }

        long halfExp = getPower(num, exp / 2L);
        long result = (halfExp * halfExp) % MOD;
        if (exp % 2L == 1L) {
            result = (result * num) % MOD;
        }
        return result;
    }
}