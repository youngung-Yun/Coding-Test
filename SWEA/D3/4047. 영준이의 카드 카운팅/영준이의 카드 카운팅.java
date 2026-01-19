import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            char[] card = {'S', 'D', 'H', 'C'};
            Map<Character, boolean[]> map = new HashMap<>();
            for (char ch : card) {
                map.put(ch, new boolean[14]);
            }
            boolean isDuplicated = false;
            String input = br.readLine();
            for (int i = 0; i < input.length(); i += 3) {
                char pattern = input.charAt(i);
                int number = Character.getNumericValue(input.charAt(i+1)) * 10 + Character.getNumericValue(input.charAt(i+2));
                // 중복되는 카드 있음
                if (map.get(pattern)[number]) {
                    isDuplicated = true;
                    break;
                }
                map.get(pattern)[number] = true;
            }
            sb.append('#').append(testCase).append(' ');
            if (isDuplicated) {
                sb.append("ERROR").append('\n');
                continue;
            }
            for (char pattern : card) {
                int count = 13;
                for (int i = 1; i <= 13; i++) {
                    if (map.get(pattern)[i]) {
                        --count;
                    }
                }
                sb.append(count).append(' ');
            }
            sb.append('\n');

        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}