import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long min = Long.min(k, n - k);
        long max = Long.max(k, n - k);

        long result = 1;
        long[] div = new long[(int) min+1];
        for (int i = 1; i < div.length; i++) {
            div[i] = i;
        }
        for (long i = max + 1L; i <= n; i++) {
            long number = i;
            for (int j = 1; j <= min; j++) {
                if (number == 1) {
                    break;
                }
                if (div[j] == 1) {
                    continue;
                }
                long gcd = getGCD(number, div[j]);
                number /= gcd;
                div[j] /= gcd;
            }
            result = (result * number) % 10_007L;
        }
        System.out.println(result);
    }

    private static long getGCD(long a, long b) {
        long min = Long.min(a, b);
        long max = Long.max(a, b);
        if (min == 0) {
            return max;
        }
        return getGCD(min, max % min);
    }
}

