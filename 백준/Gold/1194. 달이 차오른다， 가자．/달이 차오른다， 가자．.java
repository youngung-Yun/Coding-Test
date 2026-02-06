import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static char[][] maze;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][][] distance;
    static List<int[]> exits = new ArrayList<>();


    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer token = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        maze = new char[n][m];
        distance = new int[n][m][0b1 << 6];
        initDistance();

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
                } else if (object == '1') {
                    exits.add(new int[] { r, c });
                }
            }
        }
        bfs(startX, startY);
        int ans = findMinDistance();
        System.out.println(ans);
    }

    static void bfs(int x, int y) {
        // [x, y, keys]
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y , 0b0});
        distance[x][y][0b0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int cx = current[0];
            int cy = current[1];
            int keys = current[2];

            if (maze[cx][cy] == '1') {
                continue;
            }

            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                // 배열 밖이거나 이미 방문함
                if (!isValid(nx, ny) || distance[nx][ny][keys] != -1) {
                    continue;
                }
                char object = maze[nx][ny];
                // 벽
                if (object == '#') {
                    continue;
                // 열쇠
                } else if (Character.isLowerCase(object)) {
                    // 해당 키를 가지고 있지 않으면 새로운 부분집합으로 큐에 넣음
                    if (!haveKey(object, keys)) {
                        int newKey = 0b1 << (object - 'a');
                        int newKeySet = keys | newKey;

                        distance[nx][ny][newKeySet] = distance[cx][cy][keys] + 1;
                        queue.offer(new int[] {nx, ny, newKeySet});
                    }
                // 문
                } else if (Character.isUpperCase(object)) {
                    // 문에 맞는 키를 가지고 있지 않으면 지나갈 수 없음
                    if (!haveMatchingKey(object, keys)) {
                        continue;
                    }
                }
                distance[nx][ny][keys] = distance[cx][cy][keys] + 1;
                queue.offer(new int[] {nx, ny, keys});
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static void initDistance() {
        for (int[][] row : distance) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
    }

    static int findMinDistance() {
        int minDistance = -1;
        for (int[] exit : exits) {
            for (int i = 0; i < (0b1 << 6); i++) {
                int currentDistance = distance[exit[0]][exit[1]][i];
                // 못감
                if (currentDistance == -1) {
                    continue;
                } else if (minDistance == -1) {
                    minDistance = currentDistance;
                } else {
                    minDistance = Integer.min(minDistance, currentDistance);
                }
            }
        }
        return minDistance;
    }

    static boolean haveKey(char object, int keys) {
        int key = 0b1 << (object - 'a');
        return (key & keys) != 0;
    }

    static boolean haveMatchingKey(char object, int keys) {
        int door = 0b1 << (object - 'A');
        return (door & keys) != 0;
    }
}
