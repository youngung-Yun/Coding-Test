import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    final static int ROW = 12;
    final static int COL = 6;
    final static char SPACE = '.';

    static char[][] playground = new char[ROW][COL];

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < ROW; r++) {
            String line = bf.readLine();
            for (int c = 0; c < COL; c++) {
                char object = line.charAt(c);
                playground[r][c] = object;
            }
        }

        int chain = 0;
        /*
         * 1. 방문하지 않은 블록들에 대해 BFS 수행
         * 2. 상하좌우로 연결된 블록이 총 4개 이상이면, 다시 BFS 돌려서 터뜨림
         * 3. 중력 작용
         * 4. 이번 사이클에 터진 블록 없으면 반복 종료
         */
        while (true) {
            boolean findCanExplodeBlocks = false;
            boolean[][] visited = new boolean[ROW][COL];
            for (int r = 0; r < ROW; r++) {
                for (int c = 0; c < COL; c++) {
                    if (playground[r][c] == '.' || visited[r][c]) {
                        continue;
                    }
                    if (getBlockCount(visited, r, c) < 4) {
                        continue;
                    }
                    findCanExplodeBlocks = true;
                    explode(visited, r, c);
                }
            }
            activateGravity();
            if (!findCanExplodeBlocks) {
                break;
            }
            ++chain;
        }

        System.out.println(chain);
    }

    private static int getBlockCount(boolean[][] visited, int sr, int sc) {
        char block = playground[sr][sc];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        visited[sr][sc] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            ++count;
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= ROW || nc >= COL) {
                    continue;
                }
                if (playground[nr][nc] != block || visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }

        return count;
    }

    private static void explode(boolean[][] visited, int sr, int sc) {
        char block = playground[sr][sc];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            playground[r][c] = SPACE;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= ROW || nc >= COL) {
                    continue;
                }
                if (playground[nr][nc] != block) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
    }

    private static void activateGravity() {
        for (int c = 0; c < COL; c++) {
            int height = ROW - 1;
            for (int r = ROW - 1; r >= 0; r--) {
                if (playground[r][c] != SPACE) {
                    char object = playground[r][c];
                    playground[r][c] = SPACE;
                    playground[height][c] = object;
                    --height;
                }
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                sb.append(playground[r][c]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
