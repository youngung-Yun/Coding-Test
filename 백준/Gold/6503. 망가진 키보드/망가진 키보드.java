import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int m = Integer.parseInt(bf.readLine());
            if (m == 0) {
                break;
            }

            String sentence = bf.readLine();
            int n = sentence.length();

            int ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            map.put(sentence.charAt(0), 1);

            int left = 0;
            int count = 1;
            for (int right = 1; right < n; right++) {
                char ch = sentence.charAt(right);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                    ++count;
                }
                while (count > m) {
                    char remove = sentence.charAt(left);
                    if (map.get(remove) == 1) {
                        map.remove(remove);
                        --count;
                    } else {
                        map.put(remove, map.get(remove) - 1);
                    }
                    ++left;
                }
                ans = Integer.max(ans, right - left + 1);
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}