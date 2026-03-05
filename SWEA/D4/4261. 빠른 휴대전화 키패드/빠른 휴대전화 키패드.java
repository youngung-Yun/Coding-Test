import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static Map<Integer, Set<Character>> keymap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        keymap.put(2, new HashSet<>(Arrays.asList('a', 'b', 'c')));
        keymap.put(3, new HashSet<>(Arrays.asList('d', 'e', 'f')));
        keymap.put(4, new HashSet<>(Arrays.asList('g', 'h', 'i')));
        keymap.put(5, new HashSet<>(Arrays.asList('j', 'k', 'l')));
        keymap.put(6, new HashSet<>(Arrays.asList('m', 'n', 'o')));
        keymap.put(7, new HashSet<>(Arrays.asList('p', 'q', 'r', 's')));
        keymap.put(8, new HashSet<>(Arrays.asList('t', 'u', 'v')));
        keymap.put(9, new HashSet<>(Arrays.asList('w', 'x', 'y', 'z')));

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            String input = stk.nextToken();
            int n = Integer.parseInt(stk.nextToken());

            int ans = 0;
            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                String word = stk.nextToken();
                if (input.length() == word.length() && canMapped(input, word, input.length())) {
                    ++ans;
                }
            }

            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static boolean canMapped(String input, String word, int length) {
        for (int i = 0; i < length; i++) {
            int digit = input.charAt(i) - '0';
            char ch = word.charAt(i);
            if (!keymap.get(digit).contains(ch)) {
                return false;
            }
        }
        return true;
    }
}
