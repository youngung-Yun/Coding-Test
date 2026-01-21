import java.util.*;

class Solution {
    public String solution(String p) {
        // 1.
        if (p.equals("")) {
            return "";
        }
        // if (isCorrectBracketString(p)) {
        //     return p;
        // }

        // 2.
        int idx = getBalancedBracketStringIndex(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx, p.length());
        
        if (isCorrectBracketString(u)) {
            // 3.
            return u + solution(v);
        } else {
            // 4.
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(solution(v));
            sb.append(')');
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }
            return sb.toString();
        }
    }
    
    static boolean isCorrectBracketString(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    static int getBalancedBracketStringIndex(String str) {
        int[] count = new int[2];
        if (str.charAt(0) == '(') {
            ++count[0];
        } else {
            ++count[1];
        }
        
        int idx = 1;
        while (count[0] != count[1]) {
            if (str.charAt(idx) == '(') {
                ++count[0];
            } else {
                ++count[1];
            }
            ++idx;
        }
        return idx;
    }
}