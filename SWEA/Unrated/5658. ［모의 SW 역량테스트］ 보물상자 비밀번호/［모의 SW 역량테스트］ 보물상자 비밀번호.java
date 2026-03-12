import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int order = Integer.parseInt(stk.nextToken());
            int width = n / 4;

            char[] password = bf.readLine().toCharArray();

            TreeSet<Long> set = new TreeSet<>(Comparator.reverseOrder());

            for (int rotate = 0; rotate <= width; rotate++) {
                getNumbers(password, set, width);
                rotate(password, n);
            }

            long ans = 0L;
            int idx = 1;
            for (long number : set) {
                if (idx == order) {
                    ans = number;
                    break;
                }
                ++idx;
            }

            sb.append('#').append(tc).append(' ')
                    .append(ans).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static void getNumbers(char[] password, TreeSet<Long> set, int width) {
        StringBuilder sb = new StringBuilder();
        for (char ch : password) {
            sb.append(ch);
        }
        for (int i = 0; i < 4; i++) {
            long number = Long.parseLong(sb.substring(i * width, (i + 1) * width), 16);
            set.add(number);
        }
    }

    private static void rotate(char[] password, int n) {
        char last = password[n-1];
        for (int i = n - 1; i >= 1; i--) {
            password[i] = password[i-1];
        }
        password[0] = last;
    }
}
