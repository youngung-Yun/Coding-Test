import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] adj = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                adj[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        // [arrive, cost]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        pq.add(new int[] {0, 0});

        boolean[] visited = new boolean[n];

        int count = 0;
        long totalExpense = 0L;
        while (count < n) {
            int[] now = pq.poll();
            if (visited[now[0]]) {
                continue;
            }
            visited[now[0]] = true;
            ++count;
            totalExpense += now[1];

            for (int next = 0; next < n; next++) {
                if (visited[next]) {
                    continue;
                }

                pq.add(new int[] {next, adj[now[0]][next]});
            }
        }

        System.out.println(totalExpense);
    }
}
