import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).forEach((pq::add));

        for (int i = 0; i < m; i++) {
            long a = pq.poll();
            long b = pq.poll();
            long sum = a + b;
            pq.add(sum);
            pq.add(sum);
        }
        System.out.println(pq.stream().mapToLong(Long::longValue).sum());
    }
}