import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] times = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        long low = 1L;
        long high = m * times[0] + 1L;
        // 조건: k분 동안 만든 풍선 < m의 Upper Bound
        while (low <= high) {
            long mid = low + (high - low) / 2L;
            long count = 0L;
            for (long time : times) {
                count += mid / time;
            }
            if (count < m) {
                low = mid + 1L;
            } else {
                high = mid - 1L;
            }
        }
        System.out.println(low);
    }
}