import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> buffer = new ArrayDeque<>();
        int bufferSize = Integer.parseInt(br.readLine());
        int currentSize = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            } else if (n == 0) {
                buffer.removeFirst();
                --currentSize;
            } else {
                if (bufferSize > currentSize) {
                    buffer.offerLast(n);
                    ++currentSize;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (buffer.isEmpty()) {
            System.out.println("empty");
            return;
        }
        while (!buffer.isEmpty()) {
            sb.append(buffer.removeFirst()).append(' ');
        }
        System.out.println(sb.toString());
    }
}

