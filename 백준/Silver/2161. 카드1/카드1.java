import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offerLast(i);
        }
        StringBuilder sb = new StringBuilder();
        int rest = n;
        while (rest > 1) {
            int top = queue.pollFirst();
            sb.append(top).append(' ');
            top = queue.pollFirst();
            queue.offerLast(top);
            --rest;
        }

        sb.append(queue.pollFirst());

        System.out.println(sb.toString());

        br.close();
    }
}