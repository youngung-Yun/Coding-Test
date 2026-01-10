import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacency.get(a).add(b);
        }
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        // [number, distance]
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {x, 0});
        visited[x] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            if (current[1] == k) {
                result.add(current[0]);
                continue;
            }
            for (int node : adjacency.get(current[0])) {
                if (visited[node]) {
                    continue;
                }
                visited[node] = true;
                queue.offerLast(new int[] {node, current[1] + 1});
            }
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            result.sort(Comparator.naturalOrder());
            StringBuilder sb = new StringBuilder();
            for (int e : result) {
                sb.append(e).append('\n');
            }
            System.out.println(sb);
        }
    }
}
