import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer. parseInt(st.nextToken());
        int k = Integer. parseInt(st.nextToken());

        long[] array = new long[n];
        long high = 0L;
        for (int i = 0; i < n; i++) {
            long amount = Long.parseLong(br.readLine());
            array[i] = amount;
            high = Long.max(high, amount);
        }
        long low = 1L;
        ++high;
        // 조건: k명에게 나누어 줄 수 없음 -> 줄여야 함
        // 방식: lower bound
        while (low < high) {
            long mid = low + (high - low) / 2L;
            long count = 0L;
            for (long amount : array) {
                count += amount / mid;
            }
            if (count < k) {
                high = mid;
            } else {
                low = mid + 1L;
            }
        }
        System.out.println(low - 1L);
    }
}