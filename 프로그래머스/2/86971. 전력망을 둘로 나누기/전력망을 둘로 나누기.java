import java.util.*;

class Solution {
    
    static int count;
    
    public int solution(int n, int[][] wires) {
        // 전선별로 그 전선이 잘린 인접 리스트를 만들고
        // 그 중 하나의 트리에 대한 BFS로 개수 구함
        int answer = n;
        for (int i = 0; i < n - 1; i++) {
            int[] cut = wires[i];
            List<List<Integer>> adjacency = new ArrayList<>();  
            for (int k = 0; k <= n; k++) {
                adjacency.add(new ArrayList<>());
            }
            for (int k = 0; k < n - 1; k++) {
                if (i == k) {
                    continue;
                }
                int a = wires[k][0];
                int b = wires[k][1];
                adjacency.get(a).add(b);
                adjacency.get(b).add(a);
            }
            // BFS
            count = 1;
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.offerLast(cut[0]);
            boolean[] visited = new boolean[n+1];
            visited[cut[0]] = true;
            while (!queue.isEmpty()) {
                int current = queue.removeFirst();
                for (int dest : adjacency.get(current)) {
                    if (visited[dest]) {
                        continue;
                    }
                    visited[dest] = true;
                    queue.offerLast(dest);
                    ++count;
                }
            }
            int diff = Math.abs(count - (n - count));
            answer = Integer.min(diff, answer);
        }
        return answer;
    }
}