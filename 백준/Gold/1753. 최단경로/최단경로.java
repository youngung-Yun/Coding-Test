import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        List<Node>[] adjacency = new ArrayList[v + 1];
        // 인접 리스트 초기화
        for (int i = 1; i <= v; i++) {
            adjacency[i] = new ArrayList<>();
        }
        
        int startEdge = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            String[] edge = br.readLine().split(" ");
            int start = Integer.parseInt(edge[0]);
            int dest = Integer.parseInt(edge[1]);
            int cost = Integer.parseInt(edge[2]);
            adjacency[start].add(new Node(dest, cost));
        }

        int[] dist = new int[v + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[startEdge] = 0;
        
        dijkstra(startEdge, adjacency, dist);
        
        for (int i = 1; i <= v; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dijkstra(int start, List<Node>[] adjacency, int[] dist) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node curr = priorityQueue.poll();

            if (curr.cost > dist[curr.dest]) {
                continue;
            }

            // 현재 노드와 연결된 노드 가중치 비교
            for (Node node : adjacency[curr.dest]) {
                if (dist[node.dest] > curr.cost + node.cost) {
                    dist[node.dest] = curr.cost + node.cost;
                    priorityQueue.add(new Node(node.dest, dist[node.dest]));
                }
            }
        }
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
