import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        for (int n = 0; n < rows * columns; n++) {
            matrix[n / columns][n % columns] = n + 1;
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int minX = query[0] - 1;
            int minY = query[1] - 1;
            int maxX = query[2] - 1;
            int maxY = query[3] - 1;
            answer[i] = rotateAndGetMinNumber(matrix, minX, minY, maxX, maxY);
        }
        
        return answer;
    }
    
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    static int rotateAndGetMinNumber(int[][] matrix, int minX, int minY, int maxX, int maxY) {
        int x = minX;
        int y = minY;
        int prev = matrix[x][y];
        int min = prev;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            while (nx >= minX && ny >= minY && nx <= maxX && ny <= maxY) {
                int now = matrix[nx][ny];
                min = Integer.min(min, now);
                matrix[nx][ny] = prev;
                prev = now;
                x = nx;
                y = ny;
                nx += dir[0];
                ny += dir[1];
            }
        }
        return min;
    }
}