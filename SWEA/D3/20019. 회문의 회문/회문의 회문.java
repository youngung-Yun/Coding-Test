import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            String word = br.readLine();
            int center = word.length() / 2;
            boolean isPalindrome = isPalindrome(word, 0, word.length()) &&
                    isPalindrome(word, 0, center) && (isPalindrome(word, center + 1, word.length()));

            sb.append('#').append(testCase).append(' ').append(isPalindrome ? "YES" : "NO").append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static boolean isPalindrome(String str, int left, int right) {
        for (int i = left; i < right; i++) {
            if (str.charAt(i) != str.charAt(right - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}