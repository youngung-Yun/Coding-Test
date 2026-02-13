import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a1, a2) -> Integer.compare(a1[2], a2[2]));
        
        int cost = 0;
        int count = 0;
        for (int[] edge : costs) {
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];
            
            if (union(a, b)) {
                cost += c;
                ++count;
            }
            
            if (count == n - 1) {
                break;
            }
        }
        
        return cost;
    }
    
    static int find(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]);
        }
        return parent[vertex];
    }
    
    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        
        if (parentA == parentB) {
            return false;
        }
        
        parent[parentA] = parentB;
        return true;
    }
}