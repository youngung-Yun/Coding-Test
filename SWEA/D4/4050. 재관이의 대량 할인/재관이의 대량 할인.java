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
            int n = Integer.parseInt(bf.readLine());
            long ans = 0L;
            int[] clothes = new int[n];
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                clothes[i] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(clothes);
            for (int i = 0; i < n; i++) {
                if ((i + 1) % 3 == 0) {
                    continue;
                }
                ans += clothes[n-1-i];
            }

            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}