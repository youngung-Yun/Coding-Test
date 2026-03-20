import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        long a = Long.parseLong(stk.nextToken());
        long b = Long.parseLong(stk.nextToken());

        long digit = gcd(Long.max(a, b), Long.min(a, b));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digit; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    private static long gcd(long a, long b) {
        if (b == 0L) {
            return a;
        }
        return gcd(b, a % b);
    }
}