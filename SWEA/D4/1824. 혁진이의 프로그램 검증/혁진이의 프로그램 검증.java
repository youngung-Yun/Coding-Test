import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    final static int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            char[][] program = new char[r][c];
            for (int i = 0; i < r; i++) {
                String row = bf.readLine();
                for (int j = 0; j < c; j++) {
                    program[i][j] = row.charAt(j);
                }
            }

            boolean canStop = bfs(program, r, c);

            sb.append('#').append(testcase).append(' ')
                    .append(canStop ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }

    private static boolean bfs(char[][] program, int r, int c) {
        boolean[][][][] visited = new boolean[r][c][4][16];
        Queue<int[]> queue = new ArrayDeque<>();
        // 0=상, 1=하, 2=좌, 3=우
        queue.offer(new int[] {0, 0, 3, 0});
        visited[0][0][3][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];
            int dir = now[2];
            int memory = now[3];

            int newDir = dir;
            int newMemory = memory;
            char ch = program[row][col];
            if (ch == '<') {
                newDir = 2;
            } else if (ch == '>') {
                newDir = 3;
            } else if (ch == '^') {
                newDir = 0;
            } else if (ch == 'v') {
                newDir = 1;
            } else if (ch == '_') {
                newDir = memory == 0 ? 3 : 2;
            } else if (ch == '|') {
                newDir = memory == 0 ? 1 : 0;
            } else if (Character.isDigit(ch)) {
                newMemory = ch - '0';
            } else if (ch == '+') {
                newMemory = (memory + 1) % 16;
            } else if (ch == '-') {
                newMemory = (memory + 15) % 16;
            } else if (ch == '?') {
                for (int d = 0; d < 4; d++) {
                    int[] newPos = getNewPosition(r, c, row, col, dirs[d]);
                    int nr = newPos[0];
                    int nc = newPos[1];
                    if (program[nr][nc] == '@') {
                        return true;
                    }
                    if (visited[nr][nc][d][newMemory]) {
                        continue;
                    }
                    visited[nr][nc][d][newMemory] = true;
                    queue.offer(new int[] {nr, nc, d, newMemory});
                }
                continue;
            }

            int[] newPos = getNewPosition(r, c, row, col, dirs[newDir]);
            int nr = newPos[0];
            int nc = newPos[1];
            if (program[nr][nc] == '@') {
                return true;
            }
            if (visited[nr][nc][newDir][newMemory]) {
                continue;
            }
            visited[nr][nc][newDir][newMemory] = true;
            queue.offer(new int[] {nr, nc, newDir, newMemory});
        }
        return false;
    }

    private static int[] getNewPosition(int n, int m, int r, int c, int[] dir) {
        int nr = r + dir[0];
        int nc = c + dir[1];
        nr = nr == -1 ? n - 1 : nr;
        nr = nr == n ? 0 : nr;
        nc = nc == -1 ? m - 1 : nc;
        nc = nc == m ? 0 : nc;

        return new int[] {nr, nc};
    }
}