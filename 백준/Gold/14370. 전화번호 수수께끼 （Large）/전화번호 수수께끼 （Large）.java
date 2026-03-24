import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] priority = {0, 2, 6, 8, 3, 4, 5, 7, 1, 9};
    final static Map<Integer, String> map = new HashMap<>();

    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        initMap();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            String s = bf.readLine();
            count = new int[26];
            for (char ch : s.toCharArray()) {
                ++count[ch - 'A'];
            }

            char[] arr = findNumber(s);
            sb.append("Case #").append(tc).append(": ");
            for (char ch : arr) {
                sb.append(ch);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static char[] findNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (int number : priority) {
            String str = map.get(number);
            int minCount = s.length();
            Set<Character> set = new HashSet<>();
            for (char ch : str.toCharArray()) {
                set.add(ch);
            }

            for (char digit : set) {
                minCount = Integer.min(minCount, count[digit - 'A']);
            }

            for (char digit : set) {
                count[digit - 'A'] -= minCount;
            }

            for (int i = 0; i < minCount; i++) {
                sb.append(number);
            }
        }

        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        return arr;
    }

    static void initMap() {
        map.put(0, "ZERO");
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(3, "THREE");
        map.put(4, "FOUR");
        map.put(5, "FIVE");
        map.put(6, "SIX");
        map.put(7, "SEVEN");
        map.put(8, "EIGHT");
        map.put(9, "NINE");
    }
}