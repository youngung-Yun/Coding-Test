import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char bracket : s.toCharArray()) {
            if (bracket == '(') {
                stack.push(bracket);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}