import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int keyBinary = 0b1 << 6;
    final static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n;
    static int m;
    static char[][] maze;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer token = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        maze = new char[n][m];
        visited = new boolean[keyBinary][n][m];

        int startX = 0;
        int startY = 0;

        for (int r = 0; r < n; r++) {
            String row = bf.readLine();
            for (int c = 0; c < m; c++) {
                char object = row.charAt(c);
                maze[r][c] = object;
                if (object == '0') {
                    startX = r;
                    startY = c;
                }
            }
        }
        int ans = bfs(startX, startY);
        System.out.println(ans);
    }

    static int bfs(int x, int y) {
        // [x, y, keyset, distance]
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y , 0b0, 0});
        visited[0b0][x][y] = true;

        int minDistance = -1;
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int cx = current[0];
            int cy = current[1];
            int keyset = current[2];
            int distance = current[3];

            if (maze[cx][cy] == '1') {
                minDistance = distance;
                break;
            }

            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                // 배열 밖이거나 이미 방문함
                if (!isValid(nx, ny) || visited[keyset][nx][ny]) {
                    continue;
                }
                char object = maze[nx][ny];
                // 벽
                if (object == '#') {
                    continue;
                    // 열쇠
                } else if (Character.isLowerCase(object)) {
                    // 해당 키를 가지고 있지 않으면 새로운 부분집합으로 큐에 넣음
                    if (!haveKey(object, keyset)) {
                        int newKey = 0b1 << (object - 'a');
                        int newKeyset = keyset | newKey;

                        visited[newKeyset][nx][ny] = true;
                        queue.offer(new int[] {nx, ny, newKeyset, distance + 1});
                        continue;
                    }
                    // 문
                } else if (Character.isUpperCase(object)) {
                    // 문에 맞는 키를 가지고 있지 않으면 지나갈 수 없음
                    if (!haveMatchingKey(object, keyset)) {
                        continue;
                    }
                }
                visited[keyset][nx][ny] = true;
                queue.offer(new int[] {nx, ny, keyset, distance + 1});
            }
        }
        return minDistance;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static boolean haveKey(char object, int keyset) {
        int key = 0b1 << (object - 'a');
        return (key & keyset) != 0;
    }

    static boolean haveMatchingKey(char object, int keyset) {
        int door = 0b1 << (object - 'A');
        return (door & keyset) != 0;
    }
}
