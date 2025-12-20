import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // a^b = (a^(b/2)) * (a^(b/2))
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(recursion(a, b, c));
    }

    private static long recursion(long a, long b, long c) {
        if (b == 0) {
            return 1L;
        }

        long halfPow = recursion(a, b / 2L, c);
        long result = ((halfPow % c) * (halfPow % c)) % c;
        if (b % 2L == 1) {
            result = (result * (a % c)) % c;
        }
        return result;
    }
}
