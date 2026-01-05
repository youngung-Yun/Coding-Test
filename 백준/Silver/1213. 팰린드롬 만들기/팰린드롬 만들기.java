import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int[] count = new int[26];
        for (char ch : name.toCharArray()) {
            ++count[ch - 'A'];
        }
        // 개수가 홀수인 문자가 있는 경우, 이름의 길이가 짝수면 불가능
        // 이름의 길이가 홀수면서 홀수인 문자가 1개 뿐이어야 가능
        int oddCount = 0;
        for (int c : count) {
            if (c % 2 == 1) {
                ++oddCount;
            }
        }
        if (oddCount > 1 || (oddCount == 1 && name.length() % 2 == 0)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        char[] palindrome = new char[name.length()];
        int index = 0;
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (count[i] == 1) {
                    palindrome[name.length() / 2] = (char) (i + 'A');
                    --count[i];
                    continue;
                }
                char ch = (char) (i + 'A');
                palindrome[index] = ch;
                palindrome[palindrome.length - 1 - index] = ch;
                count[i] -= 2;
                ++index;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : palindrome) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
