import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testcase = 1; testcase <= t; testcase++) {
            long n = Long.parseLong(bf.readLine());

            int ans = 0;
            while (n > 2) {
                long power = (long) Math.pow(Math.ceil(Math.sqrt(n)), 2);
                ans += (power - n);
                n = (long) Math.sqrt(power);
                ++ans;
            }
            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
