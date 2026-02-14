import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int maxDistance = 0;
        int maxCount = 0;
        boolean[] visited = new boolean[n+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {1, 0});
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int node = curr[0];
            int distance = curr[1];
            if (maxDistance < distance) {
                maxDistance = distance;
                maxCount = 1;
            } else if (maxDistance == distance) {
                ++maxCount;
            }
            
            for (int next : adj.get(node)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.offer(new int[] {next, distance + 1});
            }
        }
        
        return maxCount;
    }
}