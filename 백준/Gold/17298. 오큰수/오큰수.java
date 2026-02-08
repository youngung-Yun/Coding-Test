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

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] < curr) {
                ans[stack.pop()] = curr;
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int e : ans) {
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }
}