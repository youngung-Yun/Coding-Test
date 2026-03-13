import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = -1;
    final static int WIDTH = 500;
    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 1 = 위험한 구역 (들어갈 때마다 생명력 1 깎임), 2 = 죽음의 구역 (들어갈 수 없음)
        int[][] map = new int[WIDTH+1][WIDTH+1];

        StringTokenizer stk;

        int n = Integer.parseInt(bf.readLine());
        for (int danger = 0; danger < n; danger++) {
            stk = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            int minX = Integer.min(x1, x2);
            int maxX = Integer.max(x1, x2);
            int minY = Integer.min(y1, y2);
            int maxY = Integer.max(y1, y2);
            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    map[x][y] = 1;
                }
            }
        }
        int m = Integer.parseInt(bf.readLine());
        for (int death = 0; death < m; death++) {
            stk = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            int minX = Integer.min(x1, x2);
            int maxX = Integer.max(x1, x2);
            int minY = Integer.min(y1, y2);
            int maxY = Integer.max(y1, y2);
            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    map[x][y] = 2;
                }
            }
        }

        int[][] distance = new int[WIDTH+1][WIDTH+1];
        for (int[] row : distance) {
            Arrays.fill(row, INF);
        }
        // [r, c, cost]
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[] {0, 0, 0});

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int r = now[0];
            int c = now[1];
            int cost = now[2];

            if (distance[r][c] != INF) {
                continue;
            }

            distance[r][c] = cost;
            if (r == WIDTH && c == WIDTH) {
                break;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr > WIDTH || nc > WIDTH) {
                    continue;
                }
                if (map[nr][nc] == 2) {
                    continue;
                // 위험한 구역
                } else if (map[nr][nc] == 1 && distance[nr][nc] == INF) {
                    deque.offerLast(new int[] {nr, nc, cost + 1});
                // 안전 구역
                } else if (map[nr][nc] == 0 && distance[nr][nc] == INF) {
                    deque.offerFirst(new int[] {nr, nc, cost});
                }
            }
        }

        System.out.println(distance[WIDTH][WIDTH]);
    }
}

