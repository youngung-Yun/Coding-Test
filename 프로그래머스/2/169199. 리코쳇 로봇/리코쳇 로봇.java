import java.util.*;

class Solution {
    
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int solution(String[] board) {
        int row = board.length;
        int col = board[0].length();
        int[] start = new int[2];
        int[] goal = new int[2];
        // 시작 지점과 목표 지점 찾기
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                char ch = board[r].charAt(c);
                if (ch == 'R') {
                    start[0] = r;
                    start[1] = c;
                } else if (ch == 'G') {
                    goal[0] = r;
                    goal[1] = c;
                }
            }
        }
        
        // 시작 지점부터 BFS
        int[][] distance = new int[row][col];
        for (int[] d : distance) {
            Arrays.fill(d, -1);
        }
        distance[start[0]][start[1]] = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(start);
        while (!queue.isEmpty() && distance[goal[0]][goal[1]] == -1) {
            int[] current = queue.removeFirst();
            for (int[] dir : dirs) {
                int[] next = getNextPosition(board, current, dir, row, col);
                if (distance[next[0]][next[1]] != -1) {
                    continue;
                }
                distance[next[0]][next[1]] = distance[current[0]][current[1]] + 1;
                queue.offerLast(next);
            }
        }
        
        return distance[goal[0]][goal[1]];
    }
    
    static int[] getNextPosition(String[] matrix, int[] current, int[] direction, int r, int c) {
        int x = current[0];
        int y = current[1];
        int nx = x + direction[0];
        int ny = y + direction[1];
        while (isValid(nx, ny, r, c) && matrix[nx].charAt(ny) != 'D') {
            x = nx;
            y = ny;
            nx += direction[0];
            ny += direction[1];
        }
        return new int[] {x, y};
    }
    
    static boolean isValid(int x, int y, int r, int c) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }
}