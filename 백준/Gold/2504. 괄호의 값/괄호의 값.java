import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String sequence = bf.readLine();

        boolean isCorrect = true;

        Deque<Character> bracketStack = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (char bracket : sequence.toCharArray()) {
            if (bracket == '(' || bracket == '[') {
                bracketStack.push(bracket);
                list.add(new ArrayList<>());
            } else {
                char open = bracket == ')' ? '(' : '[';
                if (bracketStack.isEmpty() || bracketStack.peek() != open) {
                    isCorrect = false;
                    break;
                }
                // 여는 괄호 제거
                bracketStack.pop();
                int sum;
                if (list.get(list.size() - 1).isEmpty()) {
                    sum = 1;
                } else {
                    sum = 0;
                    for (int number : list.get(list.size() - 1)) {
                        sum += number;
                    }
                }
                list.remove(list.size() - 1);
                if (bracket == ')') {
                    list.get(list.size() - 1).add(sum * 2);
                } else {
                    list.get(list.size() - 1).add(sum * 3);
                }
            }
        }

        int ans = 0;
        for (int number : list.get(0)) {
            ans += number;
        }

        if (isCorrect && bracketStack.isEmpty()) {
            System.out.println(ans);
        } else {
            System.out.println(0);
        }
    }
}