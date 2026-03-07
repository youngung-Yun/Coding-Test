import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String sequence = bf.readLine();

        boolean isCorrect = true;

        Deque<Character> bracketStack = new ArrayDeque<>();
        Deque<Integer> numberStack = new ArrayDeque<>();
        for (char bracket : sequence.toCharArray()) {
            if (bracket == '(' || bracket == '[') {
                bracketStack.push(bracket);
                numberStack.push(-1);
            } else {
                char open = bracket == ')' ? '(' : '[';
                if (bracketStack.isEmpty() || bracketStack.peek() != open) {
                    isCorrect = false;
                    break;
                }
                bracketStack.pop();
                int sum = 0;
                boolean hasInBracket = false;
                while (numberStack.peek() != -1) {
                    hasInBracket = true;
                    sum += numberStack.pop();
                }
                numberStack.pop();
                if (!hasInBracket) {
                    sum = 1;
                }

                if (bracket == ')') {
                    numberStack.push(sum * 2);
                } else {
                    numberStack.push(sum * 3);
                }
            }
        }

        int ans = 0;
        while (!numberStack.isEmpty()) {
            ans += numberStack.pop();
        }

        if (isCorrect && bracketStack.isEmpty()) {
            System.out.println(ans);
        } else {
            System.out.println(0);
        }
    }
}