import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long p;
    static long q;

    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        long n = Long.parseLong(stk.nextToken());
        p = Long.parseLong(stk.nextToken());
        q = Long.parseLong(stk.nextToken());

        long ans = recursion(n);
        System.out.println(ans);
    }

    private static long recursion(long n) {
        if (n == 0L) {
            return 1L;
        }
        if (!map.containsKey(n / p)) {
            map.put(n / p, recursion(n / p));
        }
        long dividedP = map.get(n / p);
        if (!map.containsKey(n / q)) {
            map.put(n / q, recursion(n / q));
        }
        long dividedQ = map.get(n / q);
        map.put(n,  dividedP + dividedQ);
        return dividedP + dividedQ;
    }
}