import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int currentHeight = arr[i];
            // 스택에 나보다 낮은 탑은 다른 탑의 레이저를 수신받을 일이 없기 때문에 제거
            while (!stack.isEmpty() && arr[stack.peek()] < currentHeight) {
                stack.pop();
            }
            // 스택의 top에 있는 탑이 나의 왼쪽에 있으면서 나보다 높은 첫 번째 탑
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}