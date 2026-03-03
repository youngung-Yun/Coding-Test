import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            long n = Long.parseLong(bf.readLine());

            Set<Long> set = new HashSet<>();
            set.add(1L);
            if (n > 1) {
                set.add(2L);
            }

            for (int fivePow = 1; Math.pow(5L, fivePow) <= n; fivePow++) {
                for (int twoPow = Math.max(0, fivePow - 3); twoPow <= fivePow + 1; twoPow++) {
                    if (Math.pow(5L, fivePow) * Math.pow(2L, twoPow) <= n) {
                        set.add((long) (Math.pow(5L, fivePow) * Math.pow(2L, twoPow)));
                    }
                }
            }

            sb.append('#').append(testcase).append(' ')
                    .append(set.size()).append('\n');
        }
        System.out.println(sb);
    }
}