import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        String bomb = bf.readLine();

        // [idx, sequence]
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (stack.isEmpty() || bomb.charAt(stack.peek()[1]) != ch) {
                stack.push(new int[]{i, ch == bomb.charAt(0) ? 1 : 0});
            } else {
                stack.push(new int[] {i, stack.peek()[1] + 1});
            }
            if (stack.peek()[1] == bomb.length()) {
                for (int j = 0; j < bomb.length(); j++) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            while (!stack.isEmpty()) {
                sb.append(str.charAt(stack.pop()[0]));
            }
            sb = sb.reverse();
        }
        System.out.println(sb);
    }
}