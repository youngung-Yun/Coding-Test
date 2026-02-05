import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int maxConnectedCellCount;
    static int minFiberCount;
    static int n;
    static int[][] processor;
    static List<int[]> cellList;

    // 0, 상, 하, 좌, 우
    static int[][] dirs = { {}, {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            maxConnectedCellCount = 0;
            minFiberCount = 0;

            n = Integer.parseInt(bf.readLine());
            processor = new int[n][n];
            cellList = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                StringTokenizer token = new StringTokenizer(bf.readLine());
                for (int c = 0; c < n; c++) {
                    int unit = Integer.parseInt(token.nextToken());
                    processor[r][c] = unit;
                    if (unit == 1) {
                        cellList.add(new int[] {r, c});
                    }
                }
            }
            dfs(0, cellList.size(), 0, 0);
            sb.append('#').append(testCase).append(' ')
                    .append(minFiberCount).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int n, int connectCell, int fiber) {
        if (depth == n) {
            if (maxConnectedCellCount < connectCell) {
                maxConnectedCellCount = connectCell;
                minFiberCount = fiber;
                return;
            } else if (maxConnectedCellCount == connectCell && fiber < minFiberCount) {
                minFiberCount = fiber;
                return;
            }
            return;
        }

        // 전선 = -1
        for (int i = 0; i < 5; i++) {
            // 해당 셀 연결하지 않음
            if (i == 0) {
                dfs(depth + 1, n, connectCell, fiber);
                continue;
            }
            int[] cell = cellList.get(depth);
            int x = cell[0];
            int y = cell[1];
            int[] dir = dirs[i];
            if (canAddFiber(x, y, dir)) {
                int addedfiber = addFiber(x, y, dir);
                ++connectCell;
                dfs(depth + 1, n, connectCell, fiber + addedfiber);
                removeFiber(x, y, dir);
                --connectCell;
            }
        }
    }

    static boolean canAddFiber(int x, int y, int[] dir) {
        int nx = x + dir[0];
        int ny = y + dir[1];
        while (isValid(nx, ny)) {
            // 전선 겹치거나 셀이 있음
            if (processor[nx][ny] == -1 || processor[nx][ny] == 1) {
                return false;
            }
            nx += dir[0];
            ny += dir[1];
        }
        return true;
    }

    static int addFiber(int x, int y, int[] dir) {
        int fiberCount = 0;
        int nx = x + dir[0];
        int ny = y + dir[1];
        while (isValid(nx, ny)) {
            processor[nx][ny] = -1;
            ++fiberCount;
            nx += dir[0];
            ny += dir[1];
        }
        return fiberCount;
    }

    static void removeFiber(int x, int y, int[] dir) {
        int nx = x + dir[0];
        int ny = y + dir[1];
        while (isValid(nx, ny)) {
            processor[nx][ny] = 0;
            nx += dir[0];
            ny += dir[1];
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static void printProcessor() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : processor) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append('\n');
        }
        sb.append('\n');
        System.out.println(sb);
    }
}