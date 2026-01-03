import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Node>> adjacency = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adjacency.get(start).add(new Node(end ,dist));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startCity] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cost, n2.cost));
        pq.add(new Node(startCity, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.cost > dist[current.dest]) {
                continue;
            }

            for (Node node : adjacency.get(current.dest)) {
                if (current.cost + node.cost < dist[node.dest]) {
                    dist[node.dest] = current.cost + node.cost;
                    pq.add(new Node(node.dest, dist[node.dest]));
                }
            }
        }
        System.out.println(dist[endCity]);
    }

    private static class Node {
        public int dest;
        public int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
