import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = 1;
        while (true) {
            String str = br.readLine();
            if (str.charAt(0) == '-') {
                break;
            }
            // 이미 짝 맞는 괄호 제거
            Deque<Character> stack = new ArrayDeque<>();
            for (char b : str.toCharArray()) {
                if (b == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(b);
                }
            }
            char[] array = new char[stack.size()];
            for (int i = array.length - 1; i >= 0; --i) {
                array[i] = stack.pop();
            }
            int count = 0;
            int last = array.length - 1;
            boolean flag = true;
            for (int offset = 0; offset < array.length / 2; ++offset) {
                char leftBracket = array[offset];
                char rightBracket = array[last - offset];
                // '} {' 짝은 바깔 괄호가 '{ }'면 이동할 필요 없음
                if (leftBracket == '}' && rightBracket == '{') {
                    if (flag) {
                        count += 2;
                        flag = false;
                    } else {
                        flag = true;
                    }

                } else if (leftBracket == '}' || rightBracket == '{') {
                    ++count;
                    flag = false;
                } else {
                    flag = false;
                }
            }
            sb.append(testCase).append(". ").append(count).append('\n');
            ++testCase;
        }
        System.out.println(sb);
    }
}
