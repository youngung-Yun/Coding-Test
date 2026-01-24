import java.util.*;

class Solution {
    
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        boolean[][] visited = new boolean[row][col];
        int[] oilAmount = new int[col];
        
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (land[i][k] == 1 && !visited[i][k]) {
                    // BFS
                    int minCol = k;
                    int maxCol = k;
                    int oil = 0;
                    Deque<int[]> queue = new ArrayDeque<>();
                    queue.offerLast(new int[] {i, k});
                    visited[i][k] = true;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.removeFirst();
                        oil += 1;
                        for (int[] dir : dirs) {
                            int nx = curr[0] + dir[0];
                            int ny = curr[1] + dir[1];
                            if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                                continue;
                            }
                            if (visited[nx][ny] || land[nx][ny] == 0) {
                                continue;
                            }
                            visited[nx][ny] = true;
                            queue.offerLast(new int[] {nx, ny});
                            minCol = Integer.min(minCol, ny);
                            maxCol = Integer.max(maxCol, ny);
                        }
                    }
                    for (int c = minCol; c <= maxCol; c++) {
                        oilAmount[c] += oil;
                    }
                }
            }
        }
        return Arrays.stream(oilAmount).max().getAsInt();
    }
}