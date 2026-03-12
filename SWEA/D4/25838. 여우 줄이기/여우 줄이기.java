import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            int length = Integer.parseInt(bf.readLine());
            String word = bf.readLine();
            Deque<Character> stack = new ArrayDeque<>();

            for (char ch : word.toCharArray()) {
                if (ch != 'x' || stack.size() < 2) {
                    stack.push(ch);
                    continue;
                }

                char top = stack.pop();
                char secondTop = stack.pop();
                if (top != 'o' || secondTop != 'f') {
                    stack.push(secondTop);
                    stack.push(top);
                    stack.push(ch);
                }
            }

            System.out.println(stack.size());
        }
    }
}
