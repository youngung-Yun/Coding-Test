import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[][] dirs = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int MAX = 1_000 * 1_000 + 1;

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        int[][][] distance = new int[r][c][2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) {
                    distance[i][j][0] = 1;
                    distance[i][j][1] = 1;
                } else {
                    distance[i][j][0] = MAX;
                    distance[i][j][1] = MAX;
                }
            }
        }

        // 벽을 안 부순 상태로 이동한 거리와 벽을 1개 부순 상태로 이동한 거리 각각 저장
        Deque<Position> queue = new ArrayDeque<>();
        queue.offerLast(new Position(0, 0, 0));
        while (!queue.isEmpty()) {
            Position current = queue.removeFirst();
            for (int[] dir : dirs) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }
                if (current.breakCount == 0) {
                    if (map[nx][ny] == 0) {
                        if (distance[nx][ny][0] < MAX) {
                            continue;
                        }
                        queue.offerLast(new Position(nx, ny, 0));
                        distance[nx][ny][0] = distance[current.x][current.y][0] + 1;
                    } else {
                        if (distance[nx][ny][1] < MAX) {
                            continue;
                        }
                        queue.offerLast(new Position(nx, ny, 1));
                        distance[nx][ny][1] = distance[current.x][current.y][0] + 1;
                    }
                } else {
                    if (map[nx][ny] == 0) {
                        if (distance[nx][ny][1] < MAX) {
                            continue;
                        }
                        queue.offerLast(new Position(nx, ny, 1));
                        distance[nx][ny][1] = distance[current.x][current.y][1] + 1;
                    }
                }
            }
        }

        if (distance[r-1][c-1][0] == MAX && distance[r-1][c-1][1] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(Integer.min(distance[r-1][c-1][0], distance[r-1][c-1][1]));
        }
    }

    static class Position {
        public int x;
        public int y;
        public int breakCount;

        public Position(int x, int y, int breakCount) {
            this.x = x;
            this.y = y;
            this.breakCount = breakCount;
        }
    }
}