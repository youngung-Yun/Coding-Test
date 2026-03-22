import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            long x = Long.parseLong(stk.nextToken());
            long y = Long.parseLong(stk.nextToken());
            long distance = y - x;

            // n * (n + 1)이 distance 보다 작은 최댓값
            long low = 1;
            long high = distance;
            while (low < high) {
                long mid = low + (high - low) / 2L;
                if ((mid * (mid + 1)) < distance) {
                    low = mid + 1L;
                } else {
                    high = mid;
                }
            }
            --low;
            long ans = low * 2L;
            distance -= low * (low + 1L);
            if (distance <= (low + 1L)) {
                ++ans;
            } else {
                ans += 2L;
            }

            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}