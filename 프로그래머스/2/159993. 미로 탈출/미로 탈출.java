import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        char[][] maze = new char[row][col];
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; c++) {
                char ch = maps[r].charAt(c);
                maze[r][c] = ch;
                if (ch == 'S') {
                    start[0] = r;
                    start[1] = c;
                } else if (ch == 'E') {
                    exit[0] = r;
                    exit[1] = c;
                } else if (ch == 'L') {
                    lever[0] = r;
                    lever[1] = c;
                }
            }
        }
        // 시작 지점 -> 레버 가는 최단경로 + 레버 -> 출구 가는 최단경로
        int shortestToLever = bfs(maze, row, col, start, lever);
        int shortestToExit = bfs(maze, row, col, lever, exit);
        
        // 레버나 출구까지 가는 길이 없으면 -1 리턴
        if (shortestToLever == -1 || shortestToExit == -1) {
            return -1;
        } else {
            return shortestToLever + shortestToExit;
        }
    }
    
    static int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    static int bfs(char[][] maze, int r, int c, int[] start, int[] dest) {
        int[][] distances = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(distances[i], -1);
        }
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(start);
        distances[start[0]][start[1]] = 0;
        while (!queue.isEmpty() && distances[dest[0]][dest[1]] == -1) {
            int[] current = queue.removeFirst();
            for (int[] dir : dirs) {
                int nx = current[0] + dir[0];
                int ny = current[1] + dir[1];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }
                if (distances[nx][ny] != -1) {
                    continue;
                }
                if (maze[nx][ny] == 'X') {
                    continue;
                }
                distances[nx][ny] = distances[current[0]][current[1]] + 1;
                queue.offerLast(new int[] {nx, ny});
            }
        }
        return distances[dest[0]][dest[1]];
    }
}