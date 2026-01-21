import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        int r = maps.length;
        int c = maps[0].length();
        char[][] map = makeMap(maps, r, c);
        
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int k = 0; k < c; k++) {
                if (map[i][k] == 'X') {
                    continue;
                }
                if (visited[i][k]) {
                    continue;
                }
                answer.add(bfs(map, visited, i, k, r, c));
            }
        }
        
        if (answer.size() == 0) {
            return new int[] {-1};
        }
        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    static int bfs(char[][] map, boolean[][] visited, int x, int y, int r, int c) {
        int count = 0;
        visited[x][y] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            count += Character.getNumericValue(map[current[0]][current[1]]);
            for (int[] dir : dirs) {
                int nx = current[0] + dir[0];
                int ny = current[1] + dir[1];
                if (!isValid(nx, ny, r, c)) {
                    continue;
                }
                if (map[nx][ny] == 'X') {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offerLast(new int[] {nx, ny});
            }
        }
        return count;
    }
    
    static boolean isValid(int x, int y, int r, int c) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }
    
    static char[][] makeMap(String[] matrix, int r, int c) {
        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int k = 0; k < c; k++) {
                map[i][k] = matrix[i].charAt(k);
            }
        }
        return map;
    }
}