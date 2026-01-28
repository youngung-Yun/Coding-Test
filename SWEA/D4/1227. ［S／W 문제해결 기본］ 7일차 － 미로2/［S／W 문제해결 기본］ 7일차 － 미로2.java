import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; testCase++) {
            final int WIDTH = 100;
            int testCaseNumber = Integer.parseInt(br.readLine());
            int[][] maze = new int[WIDTH][WIDTH];
            int[] start = new int[2];
            int[] end = new int[2];
            for (int r = 0; r < WIDTH; ++r) {
                String row = br.readLine();
                for (int c = 0; c < WIDTH; c++) {
                    int number = Character.getNumericValue(row.charAt(c));
                    maze[r][c] = number;
                    if (number == 2) {
                        start = new int[] {r, c};
                    } else if (number == 3) {
                        end = new int[] {r, c};
                    }
                }
            }
            boolean[][] visited = new boolean[WIDTH][WIDTH];
            bfs(maze, start, end, WIDTH, visited);
            sb.append('#').append(testCaseNumber).append(' ').append(visited[end[0]][end[1]] ? 1 : 0).append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int[][] matrix, int[] start, int[] end, int n, boolean[][] visited) {
        final int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty() && !visited[end[0]][end[1]]) {
            int[] curr = queue.removeFirst();
            for (int[] dir : dirs) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (matrix[nx][ny] == 1) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offerLast(new int[] {nx, ny});
            }
        }
    }
}