import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjacency.get(x).add(y);
            adjacency.get(y).add(x);
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(a);
        distances[a] = 0;
        while (distances[b] == -1 && !queue.isEmpty()) {
            int curr = queue.removeFirst();
            for (int node : adjacency.get(curr)) {
                if (distances[node] != -1) {
                    continue;
                }
                distances[node] = distances[curr] + 1;
                queue.offerLast(node);
            }
        }

        System.out.println(distances[b]);
    }
}
