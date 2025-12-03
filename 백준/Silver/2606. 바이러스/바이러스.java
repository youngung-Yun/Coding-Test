import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> adjacencyList = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        queue.offerLast(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            ++count;
            for (int dest : adjacencyList.get(node)) {
                if (!visited[dest]) {
                    visited[dest] = true;
                    queue.addLast(dest);
                }
            }
        }
        System.out.println(--count);
    }
}