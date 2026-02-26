import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            long[] times = new long[n];
            for (int i = 0; i < n; i++) {
                times[i] = Long.parseLong(bf.readLine());
            }

            long low = 1L;
            long high = (long) Math.pow(10, 18);
            long ans = 0L;

            while (low <= high) {
                long mid = low + (high - low) / 2L;
                long checkCount = check(mid, times);
                // mid 시간동안 m명이상 심사할 수 있음
                if (checkCount >= m) {
                    ans = mid;
                    high = mid - 1L;
                } else {
                    low = mid + 1L;
                }
            }

            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    private static long check(long limitTime, long[] times) {
        long count = 0;
        for (long time : times) {
            count += limitTime / time;
        }
        return count;
    }
}