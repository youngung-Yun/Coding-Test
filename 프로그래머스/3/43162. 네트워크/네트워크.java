import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int network = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            ++network;
            bfs(visited, computers, i, n);
        }
        return network;
    }
    
    public void bfs(boolean[] visited, int[][] adj, int start, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            for (int other = 0; other < n; other++) {
                if (adj[curr][other] == 0 || visited[other]) {
                    continue;
                }
                visited[other] = true;
                queue.offer(other);
            }
        }
    }
}