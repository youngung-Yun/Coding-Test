import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();

        int ans = 100;
        for (int center = str.length() / 2; center < str.length(); center++) {
            if (canOddPalindrome(str, center)) {
                int length = str.length() + (center - (str.length() - 1 - center));
                ans = Integer.min(ans, length);
            }
        }

        for (int rightCenter = (str.length() - 1) / 2 + 1; rightCenter < str.length(); rightCenter++) {
            if (canEvenPalindrome(str, rightCenter)) {
                int length = str.length() - 1 + (rightCenter - (str.length() - 1 - rightCenter));
                ans = Integer.min(ans, length);
            }
        }

        System.out.println(ans);
    }

    static boolean canOddPalindrome(String str, int center) {
        int left = center - 1;
        int right = center + 1;
        while (right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            --left;
            ++right;
        }
        return true;
    }

    static boolean canEvenPalindrome(String str, int center) {
        int left = center - 1;
        int right = center;
        while (right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            --left;
            ++right;
        }
        return true;
    }
}