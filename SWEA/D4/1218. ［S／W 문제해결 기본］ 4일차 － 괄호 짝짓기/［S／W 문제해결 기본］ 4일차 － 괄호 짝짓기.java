import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; testCase++) {
            int length = Integer.parseInt(br.readLine());
            String buckets = br.readLine();

            sb.append('#').append(testCase).append(' ').append(isValidBrackets(buckets) ? 1 : 0).append('\n');
        }
        System.out.println(sb);
    }

    static boolean isValidBrackets(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char bracket : str.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[' || bracket == '<') {
                stack.push(bracket);
                continue;
            }
            char open;
            if (bracket == ')') {
                open = '(';
            } else if (bracket == '}') {
                open = '{';
            } else if (bracket == ']') {
                open = '[';
            } else {
                open = '<';
            }

            if (stack.isEmpty() || stack.peek() != open) {
                return false;
            }

            stack.pop();
        }
        return stack.isEmpty();
    }
}