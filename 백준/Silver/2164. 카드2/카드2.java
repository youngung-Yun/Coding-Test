import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }

        while (queue.size() > 1) {
            queue.removeFirst();
            queue.addLast(queue.removeFirst());
        }

        System.out.println(queue.removeFirst());
    }
}