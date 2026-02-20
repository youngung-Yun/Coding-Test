import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            int n = Integer.parseInt(bf.readLine());
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(bf.readLine());
            }

            List<String> list = new ArrayList<>(set);

            list.sort((s1, s2) -> {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return Integer.compare(s1.length(), s2.length());
                }
            });

            sb.append('#').append(testcase).append('\n');
            for (String name : list) {
                sb.append(name).append('\n');
            }
        }
        System.out.println(sb);
    }
}
