import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            String record = bf.readLine();
            int c = 0;
            int r = 0;
            int o = 0;
            int a = 0;

            int ans = -1;

            int count = 0;
            for (char ch : record.toCharArray()) {
                if (ch == 'c') {
                    ++c;
                    ++count;
                    ans = Integer.max(ans, count);
                } else if (ch == 'r') {
                    if (c <= 0) {
                        ans = -1;
                        break;
                    }
                    --c;
                    ++r;
                } else if (ch == 'o') {
                    if (r <= 0) {
                        ans = -1;
                        break;
                    }
                    --r;
                    ++o;
                } else if (ch == 'a') {
                    if (o <= 0) {
                        ans = -1;
                        break;
                    }
                    --o;
                    ++a;
                } else if (ch == 'k') {
                    if (a <= 0) {
                        ans = -1;
                        break;
                    }
                    --a;
                    --count;
                }
            }

            if (c > 0 || r > 0 || o > 0 || a > 0) {
                ans = -1;
            }

            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
