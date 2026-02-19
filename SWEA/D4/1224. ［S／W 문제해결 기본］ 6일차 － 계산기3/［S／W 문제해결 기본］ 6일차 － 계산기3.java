import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int testcase = 1; testcase <= 10; testcase++) {
            int len = Integer.parseInt(bf.readLine());
            String expression = bf.readLine();

            Deque<Character> postorderQueue = makePostorderQueue(expression);

            Deque<Integer> numberStack = new ArrayDeque<>();
            while (!postorderQueue.isEmpty()) {
                char ch = postorderQueue.remove();
                if (Character.isDigit(ch)) {
                    numberStack.push(ch - '0');
                } else if (ch == '*') {
                    int num1 = numberStack.pop();
                    int num2 = numberStack.pop();
                    numberStack.push(num1 * num2);
                } else if (ch == '+') {
                    int num1 = numberStack.pop();
                    int num2 = numberStack.pop();
                    numberStack.push(num1 + num2);
                }
            }

            int ans = numberStack.pop();
            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static Deque<Character> makePostorderQueue(String expression) {
        Deque<Character> tempStack = new ArrayDeque<>();
        Deque<Character> postorderQueue = new ArrayDeque<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                postorderQueue.offer(ch);
            } else if (ch == '(' || ch == '*') {
                tempStack.push(ch);
            } else if (ch == '+') {
                while (!tempStack.isEmpty() && tempStack.peek() != '(') {
                    postorderQueue.offer(tempStack.pop());
                }
                tempStack.push(ch);
            } else if (ch == ')') {
                while (tempStack.peek() != '(') {
                    postorderQueue.offer(tempStack.pop());
                }
                tempStack.pop();
            }
        }
        while (!tempStack.isEmpty()) {
            postorderQueue.offer(tempStack.pop());
        }

        return postorderQueue;
    }
}
