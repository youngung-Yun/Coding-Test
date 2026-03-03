import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    final static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {

            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());
            int[] lectures = new int[n];
            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                lectures[i] = Integer.parseInt(stk.nextToken());
            }

            double ans = 0.0;
            Arrays.sort(lectures);
            for (int i = n - k; i < n; i++) {
                ans = (ans + lectures[i]) / 2.0;
            }

            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}