
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int farthestDistance = 0;
    static int farthestNode = 0;

    static List<List<Edge>> adjacency;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        adjacency = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjacency.get(a).add(new Edge(b, c));
            adjacency.get(b).add(new Edge(a, c));
        }

        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, 0);
        farthestDistance = 0;
        visited = new boolean[n+1];
        visited[farthestNode] = true;
        dfs(farthestNode, 0);
        System.out.println(farthestDistance);
    }

    static void dfs(int node, int distance) {
        if (distance > farthestDistance) {
            farthestDistance = distance;
            farthestNode = node;
        }

        for (Edge edge : adjacency.get(node)) {
            if (visited[edge.dest]) {
                continue;
            }
            visited[edge.dest] = true;
            dfs(edge.dest, distance + edge.cost);
            visited[edge.dest] = false;
        }
    }

    static class Edge {
        public int dest;
        public int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}