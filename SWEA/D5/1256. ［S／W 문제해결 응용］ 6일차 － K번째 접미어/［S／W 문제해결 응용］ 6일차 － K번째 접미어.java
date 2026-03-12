import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int k = Integer.parseInt(bf.readLine());
            String word = bf.readLine();
            int n = word.length();

            TreeSet<String> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(word.substring(n - 1 - i, n));
            }

            String ans = "";
            if (set.size() < k) {
                ans = "none";
            } else {
                int order = 1;
                for (String suffix : set) {
                    if (k == order) {
                        ans = suffix;
                        break;
                    }
                    ++order;
                }
            }
            sb.append('#').append(tc).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

}
