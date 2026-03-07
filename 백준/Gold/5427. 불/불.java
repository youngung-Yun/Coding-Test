import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int h;
    static int w;
    final static int[] dx = {0, 0, 1, -1};
    final static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bf.readLine());

        while (testcase-- > 0) {
            List<int[]> fires = new ArrayList<>();
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            w = Integer.parseInt(stk.nextToken());
            h = Integer.parseInt(stk.nextToken());
            char[][] building = new char[h][w];

            int startR = 0;
            int startC = 0;

            for (int r = 0; r < h; r++) {
                String row = bf.readLine();
                for (int c = 0; c < w; c++) {
                    char object = row.charAt(c);
                    building[r][c] = object;
                    if (object == '@') {
                        startR = r;
                        startC = c;
                    } else if (object == '*') {
                        fires.add(new int[] {r, c});
                    }
                }
            }


            Queue<int[]> fireQueue = new ArrayDeque<>();
            for (int[] fire : fires) {
                fireQueue.offer(fire);
            }
            Queue<int[]> moveQueue = new ArrayDeque<>();
            moveQueue.offer(new int[] {startR, startC});
            boolean[][] visited = new boolean[h][w];
            visited[startR][startC] = true;

            int time = 0;
            int ans = 0;
            boolean canEscape = false;
            while (!canEscape && !moveQueue.isEmpty()) {
                ++time;
                // 불 이동
                int fireCount = fireQueue.size();
                while (fireCount-- > 0) {
                    int[] now = fireQueue.poll();

                    for (int d = 0; d < 4; d++) {
                        int nr = now[0] + dx[d];
                        int nc = now[1] + dy[d];
                        if (!isValidPos(nr, nc) || building[nr][nc] == '*' || building[nr][nc] == '#') {
                            continue;
                        }
                        building[nr][nc] = '*';
                        fireQueue.offer(new int[] {nr, nc});
                    }
                }

                // 이동
                int moveCount = moveQueue.size();
                while (moveCount-- > 0) {
                    int[] now = moveQueue.poll();
                    for (int d = 0; d < 4; d++) {
                        int nr = now[0] + dx[d];
                        int nc = now[1] + dy[d];
                        if (!isValidPos(nr, nc)) {
                            canEscape = true;
                            ans = time;
                            break;
                        }
                        if (building[nr][nc] != '.' || visited[nr][nc]) {
                            continue;
                        }
                        visited[nr][nc] = true;
                        moveQueue.offer(new int[] {nr, nc});
                    }
                }
            }

            if (canEscape) {
                System.out.println(ans);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static boolean isValidPos(int r, int c) {
        return r >= 0 && c >= 0 && r < h && c < w;
    }
}