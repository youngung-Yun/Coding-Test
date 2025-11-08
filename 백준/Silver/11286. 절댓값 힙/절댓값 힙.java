import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>((n1, n2) -> {
            if (Math.abs(n1) == Math.abs(n2)) {
                return Integer.compare(n1, n2);
            }
            return Integer.compare(Math.abs(n1), Math.abs(n2));
        });

        for (int i = 0; i < n; i++) {
            int info = Integer.parseInt(br.readLine());

            if (info == 0) {
                sb.append(pQueue.isEmpty() ? 0 : pQueue.poll()).append('\n');
            }
            else {
                pQueue.add(info);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
