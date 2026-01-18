import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            String n = br.readLine();
            Set<Character> set = new HashSet<>();
            for (char ch : n.toCharArray()) {
                if (set.contains(ch)) {
                    set.remove(ch);
                } else {
                    set.add(ch);
                }
            }

            sb.append('#').append(testCase).append(' ').append(set.size()).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}