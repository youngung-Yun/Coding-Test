import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] recievers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[n];

        // [index,height]
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int[] curr = {i, recievers[i]};
            while (!stack.isEmpty() && stack.peek()[1] <= curr[1]) {
                int[] lower = stack.pop();
                answer[lower[0]] = curr[0] + 1;
            }
            stack.push(curr);
        }
        while (!stack.isEmpty()) {
            int[] higher = stack.pop();
            answer[higher[0]] = 0;
        }

        for (int e : answer) {
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }
}