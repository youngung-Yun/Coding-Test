import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[] distance = new int[N+1];
        Arrays.fill(distance, 2_000 * 10_000 + 1);
        
        List<List<Node>> adjacency = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjacency.add(new ArrayList<>());
        }
        
        for (int[] edge : road) {
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];
            adjacency.get(a).add(new Node(b, c));
            adjacency.get(b).add(new Node(a, c));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cost, n2.cost));
        pq.add(new Node(1, 0));
        distance[1] = 0;
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            // 이미 더 짧은 경로가 발견되었으면 스킵
            if (current.cost > distance[current.number]) {
                continue;
            }
            
            // 포함시킨 노드로 갈 수 있는 경로가 기존보다 짧으면 갱신 후 큐에 삽입
            for (Node node : adjacency.get(current.number)) {
                if (distance[node.number] > distance[current.number] + node.cost) {
                    distance[node.number] = distance[current.number] + node.cost;
                    pq.add(new Node(node.number, distance[node.number]));
                }
            }
        }
        int answer = 0;
        for (int d : distance) {
            answer += d <= K ? 1 : 0;
        }
        return answer;
    }
    
    static class Node {
        public int number;
        public int cost;
        
        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }
}