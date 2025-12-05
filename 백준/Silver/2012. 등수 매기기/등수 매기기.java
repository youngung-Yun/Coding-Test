import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int predictedRank = Integer.parseInt(br.readLine());
            pq.add(predictedRank);
        }
        int realRank = 1;
        long result = 0;
        while (!pq.isEmpty()) {
            int predictedRank = pq.poll();
            result += Math.abs(predictedRank - realRank);
            ++realRank;
        }
        System.out.println(result);
    }
}