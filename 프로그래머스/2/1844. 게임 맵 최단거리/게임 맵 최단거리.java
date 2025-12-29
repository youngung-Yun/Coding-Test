import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] distances = new int[n][m];
        for (int[] row : distances) {
            Arrays.fill(row, -1);
        }
        int[][] directions = new int[][] {{1, 0}, {-1 ,0}, {0, 1}, {0, -1}};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {0, 0});
        distances[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();
            for (int[] direction : directions) {
                int dx = curr[0] + direction[0];
                int dy = curr[1] + direction[1];
                if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                    continue;
                }
                if (maps[dx][dy] == 0) {
                    continue;
                }
                if (distances[dx][dy] != -1) {
                    continue;
                }
                distances[dx][dy] = distances[curr[0]][curr[1]] + 1;
                queue.offerLast(new int[] {dx, dy});
            }
        }
        return distances[n-1][m-1];
    }
}