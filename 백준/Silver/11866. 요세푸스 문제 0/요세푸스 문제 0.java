import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; ++i) {
            queue.add(i);
        }

        sb.append("<");
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; ++i) {
                int x = queue.poll();
                queue.add(x);
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");

        bw.write(sb.toString());
        bw.flush();
    }

}   