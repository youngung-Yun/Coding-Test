import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // [idx, number]
        Deque<int[]> stack = new ArrayDeque<>();

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0 ; i < n; i++) {
            int number = Integer.parseInt(stk.nextToken());
            while (!stack.isEmpty() && stack.peek()[1] < number) {
                int[] lower = stack.pop();
                ans[lower[0]] = number;
            }
            stack.push(new int[] {i, number});
        }

        StringBuilder sb = new StringBuilder();
        for (int e : ans) {
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }
}