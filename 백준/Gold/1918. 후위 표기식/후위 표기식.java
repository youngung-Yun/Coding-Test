import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String expression = bf.readLine();
        StringBuilder postorder = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        /*
         * 스택에 넣기 전 내 앞에 있는, 나보다 우선순위가 같거나 높은 연산자를 전부 빼야함
         * 피연산자임: 바로 출력에 넣기
         * '(', '*' 또는 '/'임: 연산자 스택에 넣기
         *  '+', '-' 임: 스택의 비어있지 않고 top이 '('이 아닌 동안 스택에서 빼서 출력에 넣은 후 스택에 넣기
         *  ')'임: 스택의 top이 '('일 때 까지 스택에서 빼서 출력에 넣기
         *  끝난 후 스택에 남은 것들 출력에 넣기
         */
        for (char ch : expression.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                postorder.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == '*' || ch == '/') {
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    postorder.append(stack.pop());
                }
                stack.push(ch);
            } else if (ch == '+' || ch == '-') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postorder.append(stack.pop());
                }
                stack.push(ch);
            } else if (ch == ')') {
                while (stack.peek() != '(') {
                    postorder.append(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            postorder.append(stack.pop());
        }

        System.out.println(postorder);
    }
}