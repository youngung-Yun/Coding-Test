import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            String encrypted = br.readLine();
            String original = br.readLine();
            int size = original.length();
            int[] originalCount = new int[26];
            int[] windowCount = new int[26];
            for (char c : original.toCharArray()) {
                ++originalCount[c - 'a'];
            }

            for (int i = 0; i < size; i++) {
                char c = encrypted.charAt(i);
                ++windowCount[c - 'a'];
            }
            if (isValid(originalCount, windowCount)) {
                sb.append("YES").append('\n');
                continue;
            }

            boolean result = false;
            for (int i = size; i < encrypted.length(); i++) {
                --windowCount[encrypted.charAt(i-size) - 'a'];
                ++windowCount[encrypted.charAt(i) - 'a'];
                if (isValid(originalCount, windowCount)) {
                    result = true;
                    break;
                }
            }
            if (result) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);
    }

    static boolean isValid(int[] original, int[] target) {
        for (int i = 0; i < original.length; i++) {
            if (original[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}