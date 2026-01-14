import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Character> shortcuts = new HashSet<>();
        // 1. 문자열의 첫 글자, 그리고 공백 다음으로 오는 문자가 숏컷으로 지정되었는지 확인
        // 2. 문자열의 앞에서부터 공백 제외하고 숏컷으로 지정되었는지 확인
        // 3. 등록된 숏컷은 Set에 넣음
        // 4. 숏컷 만들 수 없으면 그냥 출력
        // 5. 숏컷 있으면 그 글자를 [ ] 로 감싸서 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String option = br.readLine();
            int shortcutIndex = -1;
            // 1.
            for (int k = 0; k < option.length(); k++) {
                if (k > 0 && option.charAt(k - 1) != ' ') {
                    continue;
                }
                char ch = option.charAt(k);
                if (!shortcuts.contains(Character.toUpperCase(ch))) {
                    shortcutIndex = k;
                    break;
                }
            }
            // 2.
            if (shortcutIndex == -1) {
                for (int k = 0; k < option.length(); k++) {
                    char ch = option.charAt(k);
                    if (ch == ' ') {
                        continue;
                    }
                    if (!shortcuts.contains(Character.toUpperCase(ch))) {
                        shortcutIndex = k;
                        break;
                    }
                }
            }
            for (int k = 0; k < option.length(); k++) {
                char ch = option.charAt(k);
                if (k == shortcutIndex) {
                    // 3.
                    shortcuts.add(Character.toUpperCase(ch));
                    // 5.
                    sb.append('[').append(ch).append(']');
                } else {
                    // 4.
                    sb.append(ch);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}