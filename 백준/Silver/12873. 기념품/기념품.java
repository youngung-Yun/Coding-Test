import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        long t = 1L;
        while (queue.size() > 1) {
            long power = (long) Math.pow(t, 3);
            long count = (power - 1L) % queue.size();
            for (long i = 0L; i < count; i++) {
                queue.offer(queue.remove());
            }
            queue.poll();
            ++t;
        }

        System.out.println(queue.peek());
    }
}