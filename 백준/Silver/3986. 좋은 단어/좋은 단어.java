import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int goodWord = 0;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            for (char ch : word.toCharArray()) {
                if (!stack.isEmpty() && ch == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            if (stack.isEmpty()) {
                ++goodWord;
            }
        }

        System.out.println(goodWord);
    }
}