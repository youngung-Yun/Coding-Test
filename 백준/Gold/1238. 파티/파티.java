import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MAX = 1_000 * 101;

        StringTokenizer st = new  StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<List<Node>> adjacency = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adjacency.get(a).add(new Node(b, dist));
        }

        int[] roundTrips = new int[n+1];
        for (int i = 1; i <= n; i++) {
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
            int[] dist = new int[n+1];
            Arrays.fill(dist, MAX);
            priorityQueue.add(new Node(i, 0));

            while (!priorityQueue.isEmpty()) {
                Node curr = priorityQueue.poll();

                if (curr.cost > dist[curr.dest]) {
                    continue;
                }

                for (Node node : adjacency.get(curr.dest)) {
                    if (dist[node.dest] > curr.cost + node.cost) {
                        dist[node.dest] = curr.cost + node.cost;
                        priorityQueue.add(new Node(node.dest, dist[node.dest]));
                    }
                }
            }
            if (i == x) {
                for (int j = 1; j <= n; j++) {
                    roundTrips[j] += dist[j];
                }
            } else {
                roundTrips[i] += dist[x];
            }
        }

        int result = 0;
        for (int distance : roundTrips) {
            result = Integer.max(result, distance);
        }
        System.out.println(result);
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
