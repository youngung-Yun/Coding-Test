import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        // [value, idx, version]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
            if (a1[0] != a2[0]) {
                return Integer.compare(a1[0], a2[0]);
            }
            if (a1[1] != a2[1]) {
                return Integer.compare(a1[1], a2[1]);
            }
            return Integer.compare(a2[2], a1[2]);
        });

        int[] version = new int[n+1];

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(stk.nextToken());
            pq.add(new int[] {value, i, ++version[i]});
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(bf.readLine());
        for (int q = 0; q < m; q++) {
            stk = new StringTokenizer(bf.readLine());
            int query = Integer.parseInt(stk.nextToken());
            if (query == 1) {
                int idx = Integer.parseInt(stk.nextToken());
                int value = Integer.parseInt(stk.nextToken());
                pq.add(new int[] {value, idx, ++version[idx]});
            } else {
                int[] min = pq.peek();
                while (min[2] != version[min[1]]) {
                    pq.poll();
                    min = pq.peek();
                }
                sb.append(min[1]).append('\n');
            }
        }
        System.out.println(sb);
    }
}