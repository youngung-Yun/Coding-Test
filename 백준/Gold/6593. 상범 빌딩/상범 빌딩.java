import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = {
            {1, 0, 0},
            {-1, 0, 0},
            {0, 1, 0},
            {0, -1, 0},
            {0, 0, -1},
            {0, 0, 1}
    };
    final static int INF = -1;
    static int l;
    static int r;
    static int c;
    static char[][][] building;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            l = Integer.parseInt(stk.nextToken());
            r = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            building = new char[l][r][c];
            int[][][] distance = initDistance();
            int exitX = 0;
            int exitY = 0;
            int exitZ = 0;

            Queue<int[]> queue = new ArrayDeque<>();
            for (int x = 0; x < l; x++) {
                for (int y = 0; y < r; y++) {
                    String row = bf.readLine();
                    for (int z = 0; z < c; z++) {
                        char object = row.charAt(z);
                        building[x][y][z] = object;
                        if (object == 'S') {
                            queue.offer(new int[] {x, y, z});
                            distance[x][y][z] = 0;
                        } else if (object == 'E') {
                            exitX = x;
                            exitY = y;
                            exitZ = z;
                        }
                    }
                }
                bf.readLine();
            }

            while (!queue.isEmpty() && distance[exitX][exitY][exitZ] == INF) {
                int[] current = queue.poll();
                for (int[] dir : dirs) {
                    int nx = current[0] + dir[0];
                    int ny = current[1] + dir[1];
                    int nz = current[2] + dir[2];
                    if (!isValid(nx, ny, nz)) {
                        continue;
                    }
                    if (building[nx][ny][nz] == '#' || distance[nx][ny][nz] != INF) {
                        continue;
                    }

                    distance[nx][ny][nz] = distance[current[0]][current[1]][current[2]] + 1;
                    queue.offer(new int[] {nx, ny, nz});
                }
            }

            if (distance[exitX][exitY][exitZ] == INF) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(distance[exitX][exitY][exitZ])
                        .append(" minute(s).\n");
            }
        }
        System.out.println(sb);
    }

    private static int[][][] initDistance() {
        int[][][] grid = new int[l][r][c];
        for (int x = 0; x < l; x++) {
            for (int y = 0; y < r; y++) {
                for (int z = 0;z < c; z++) {
                    grid[x][y][z] = INF;
                }
            }
        }
        return grid;
    }

    private static boolean isValid(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < l && y < r && z < c;
    }
}