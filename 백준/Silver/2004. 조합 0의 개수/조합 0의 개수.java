import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        long n = Long.parseLong(stk.nextToken());
        long m = Long.parseLong(stk.nextToken());

        long min = Long.min(m, n - m);
        long max = Long.max(m, n - m);

        long two = getCount(max + 1, n, 2) - getCount(1, min, 2);
        long five = getCount(max + 1, n , 5) - getCount(1, min, 5);

        System.out.println(Long.min(two, five));
    }

    static long getCount(long min, long max, long base) {
        long count = 0L;
        long curr = base;
        while (curr <= max) {
            long start = ((long) Math.ceil((1.0 * min / curr))) * curr;
            if (start > max) {
                break;
            }
            count += (max - start) / curr + 1L;
            curr *= base;
        }
        return count;
    }
}