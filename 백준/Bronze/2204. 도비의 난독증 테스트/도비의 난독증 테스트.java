import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparing(String::toLowerCase));
            for (int i = 0; i < n; i++) {
                pq.add(br.readLine());
            }
            sb.append(pq.poll()).append('\n');
        }
        System.out.println(sb.toString());
    }
}

