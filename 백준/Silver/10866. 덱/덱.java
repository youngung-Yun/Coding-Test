import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            int x = 0;
            if (command.length == 2) {
                x = Integer.parseInt(command[1]);
            }
            switch (command[0]) {
                case "push_front":
                    deque.offerFirst(x);
                    break;
                case "push_back":
                    deque.offerLast(x);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.removeFirst());
                    }
                    sb.append('\n');
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.removeLast());
                    }
                    sb.append('\n');
                    break;
                case "size":
                    sb.append(deque.size());
                    sb.append('\n');
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0);
                    sb.append('\n');
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peekFirst());
                    }
                    sb.append('\n');
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peekLast());
                    }
                    sb.append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
