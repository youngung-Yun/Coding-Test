import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            String word = stk.nextToken();
            String shortcut = stk.nextToken();

            String replaced = word.replaceAll(shortcut, "");

            int ans = ((word.length() - replaced.length()) / shortcut.length()) + replaced.length();

            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
