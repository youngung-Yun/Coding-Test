import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);
        distance[destination] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : adj.get(now)) {
                if (distance[next] != -1) {
                    continue;
                }
                distance[next] = distance[now] + 1;
                queue.offer(next);
            }
        }
        
        int[] ans = new int[sources.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = distance[sources[i]];
        }
        return ans;
    }
}