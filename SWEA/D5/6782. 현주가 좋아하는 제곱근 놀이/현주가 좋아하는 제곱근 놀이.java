import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    static long MAX = 1_000_000_000_000L;
    static List<Long> powers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        powers = getPowers();

        int t = Integer.parseInt(bf.readLine());
        for (int testcase = 1; testcase <= t; testcase++) {
            long n = Long.parseLong(bf.readLine());

            long ans = computeMinCount(n);

            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static long computeMinCount(long n) {
        long count = 0L;
        while (n > 2) {
            long power = binarySearch(n);
            count += (power - n);
            n = (long) Math.sqrt(power);
            ++count;
        }
        return count;
    }

    // 자신보다 크거나 같은 멱수 중 가장 작은 수를 구해야 함
    // lower case
    static long binarySearch(long n) {
        int low = 0;
        int high = powers.size();

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (powers.get(mid) < n) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return powers.get(ans);
    }

    static List<Long> getPowers() {
        List<Long> list = new ArrayList<>();
        for (Long n = 2L; n * n <= MAX; n++) {
            list.add(n * n);
        }
        return list;
    }
}