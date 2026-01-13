import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            long n = Long.parseLong(br.readLine());
            // 1 + 2 + 3 + ... + k <= n 이면 low 증가, > n이면 high 감소
            // 이후 low에 1 뺌
            // 방식: upper bound
            long low = 1L;
            long high = 200_000_001L;
            while (low < high) {
                long mid = low + (high - low) / 2L;
                long total = getSigmaN(mid);
                if (check(total, n)) {
                    low = mid + 1L;
                } else {
                    high = mid;
                }
            }
            sb.append(low - 1).append('\n');
        }
        System.out.println(sb);
    }

    static boolean check(long total, long n) {
        return total <= n;
    }

    static long getSigmaN(long n) {
        if (n % 2L == 0L) {
            return (n / 2L) * (n + 1L);
        } else {
            return ((n + 1L) / 2L) * n;
        }
    }
}