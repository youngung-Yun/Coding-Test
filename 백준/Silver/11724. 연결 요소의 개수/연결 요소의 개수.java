import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjacency.get(u).add(v);
            adjacency.get(v).add(u);
        }
        boolean[] visited = new boolean[n+1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            ++count;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offerLast(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int curr = queue.removeFirst();
                for (int node : adjacency.get(curr)) {
                    if (visited[node]) {
                        continue;
                    }
                    queue.offerLast(node);
                    visited[node] = true;
                }
            }
        }
        System.out.println(count);
    }
}