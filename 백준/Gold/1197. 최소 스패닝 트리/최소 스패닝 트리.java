import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 프림 알고리즘으로 구현
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        // 인접 리스트 초기화
        List<Edge>[] adjList = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            String[] temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int dest = Integer.parseInt(temp[1]);
            int cost = Integer.parseInt(temp[2]);
            adjList[start].add(new Edge(dest, cost));
            adjList[dest].add(new Edge(start, cost));
        }

        // 방문 체크 배열
        boolean[] visited = new boolean[v + 1];
        visited[1] = true;

        // 시작 지점과 연결된 간선 우선순위 큐에 넣음
        PriorityQueue<Edge> pQueue = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
        for (Edge edge : adjList[1]) {
            pQueue.add(edge);
        }

        int count = 0;
        int total = 0;

        while (count < v - 1) {
            Edge curr = pQueue.poll();

            // 사이클이 생기는 간선 무시
            if (visited[curr.dest]) {
                continue;
            }

            visited[curr.dest] = true;
            ++count;
            total += curr.cost;

            // 사이클이 형성되는 간선은 넣지 않음
            for (Edge edge : adjList[curr.dest]) {
                if (!visited[edge.dest]) {
                    pQueue.add(edge);
                }
            }

        }

        System.out.println(total);
    }

    private static class Edge {
        public int dest;
        public int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
