import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    static int n;
    static int m;
    static int[][] map;
    static int islandCount = 0;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        /*
         * 1. 섬 분류
         * 2. 각 섬별로 다른 섬으로 가는 경로 구함
         * 3. MST 구함
         */

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new int[n][m];
        for (int r = 0; r < n; r++) {
            stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        classifyIslands();

        parent = IntStream.rangeClosed(0, islandCount).toArray();

        // [a, b, c]
        List<int[]> edges = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] == 0) {
                    continue;
                }

                int island = map[r][c];
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    int distance = 0;
                    // 해당 방향이 내륙인 경우 제외
                    if (!isValid(nr, nc) || map[nr][nc] == island) {
                        continue;
                    }

                    while (isValid(nr, nc)) {
                        // 다른 섬에 도착
                        if (map[nr][nc] != 0) {
                            if (distance >= 2) {
                                int arriveIsland = map[nr][nc];
                                edges.add(new int[]{island - 2, arriveIsland - 2, distance});
                            }
                            break;
                        }
                        nr += dir[0];
                        nc += dir[1];
                        ++distance;
                    }
                }
            }
        }

        edges.sort((e1, e2) -> Integer.compare(e1[2], e2[2]));

        int count = 0;
        int totalLength = 0;
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];

            if (!union(a, b)) {
                continue;
            }

            ++count;
            totalLength += c;

            if (count == islandCount - 1) {
                break;
            }
        }

        if (count < islandCount - 1) {
            System.out.println(-1);
        } else {
            System.out.println(totalLength);
        }
    }

    private static void classifyIslands() {
        int island = 1;
        boolean[][] visited = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] != 0 && !visited[r][c]) {
                    ++islandCount;
                    ++island;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[] {r, c});
                    map[r][c] = island;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for (int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if (!isValid(nr, nc) || visited[nr][nc] || map[nr][nc] == 0) {
                                continue;
                            }
                            visited[nr][nc] = true;
                            map[nr][nc] = island;
                            queue.offer(new int[] {nr, nc});
                        }
                    }
                }
            }
        }
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    private static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static boolean union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return false;
        }

        if (xParent < yParent) {
            parent[yParent] = xParent;
        } else {
            parent[xParent] = yParent;
        }
        return true;
    }
}