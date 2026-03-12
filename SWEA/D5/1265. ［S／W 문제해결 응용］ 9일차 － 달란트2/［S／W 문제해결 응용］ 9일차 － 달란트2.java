import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int talent = Integer.parseInt(stk.nextToken());
            int p = Integer.parseInt(stk.nextToken());

            int count = talent / p;
            int remain = talent % p;

            long ans = 1;
            for (int i = 0; i < p; i++) {
                ans *= (remain-- > 0 ? count + 1 : count);
            }

            sb.append('#').append(tc).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}