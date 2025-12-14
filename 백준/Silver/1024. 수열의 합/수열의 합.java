import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        길이가 k고 그 중 최솟값이 m이면
        n = (0~k-1까지의 합) + (m * k)
        (n - (0~k-1까지의 합)) % k == 0이면 존재함
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long l = Long.parseLong(st.nextToken());
        for (long i = l; i <= 100; i++) {
            long sum = getSum(i - 1);
            if (sum > n) {
                break;
            }
            double m = (n - sum) / (double) i;
            if (m % 1.0 == 0) {
                StringBuilder sb = new StringBuilder();
                for (long j = (long) m; j < m + i; j++) {
                    sb.append(j).append(' ');
                }
                System.out.println(sb.toString());
                return;
            }
        }
        System.out.println(-1);
    }

    private static long getSum(long n) {
        return ((1L + n) * n) / 2L;
    }
}
