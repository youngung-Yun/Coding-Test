import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        Map<Character, Character> mirror = new HashMap<>();
        mirror.put('b', 'd');
        mirror.put('d', 'b');
        mirror.put('p', 'q');
        mirror.put('q', 'p');
        for (int t = 1; t <= testCase; t++) {
            String word = br.readLine();
            StringBuilder result = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                result.append(mirror.get(ch));
            }

            sb.append('#').append(t).append(' ').append(result.toString()).append('\n');
        }
        System.out.println(sb);
    }
}