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
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int z = Integer.parseInt(stk.nextToken());

            StringBuilder a = new StringBuilder();
            for (int l = 0; l < x; l++) {
                a.append(1);
            }
            StringBuilder b = new StringBuilder();
            for (int l = 0; l < y; l++) {
                b.append(1);
            }
            StringBuilder c = new StringBuilder();
            for (int l = 0; l < z; l++) {
                c.append(1);
            }

            if (x < z) {
                for (int l = 0; l < z; l++) {
                    a.append(0);
                    c.append(0);
                }
            }

            sb.append('#').append(testcase).append(' ')
                    .append(a).append(' ')
                    .append(b).append(' ')
                    .append(c).append('\n');
        }
        System.out.println(sb);
    }
}