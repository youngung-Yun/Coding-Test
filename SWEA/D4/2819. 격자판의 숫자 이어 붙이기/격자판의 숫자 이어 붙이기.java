import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int[][] board = new int[4][4];
            for (int r = 0; r < 4; r++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for (int c = 0; c < 4; c++) {
                    board[r][c] = Integer.parseInt(token.nextToken());
                }
            }

            Set<Integer> set = new HashSet<>();
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    Deque<int[]> queue = new ArrayDeque<>();
                    // [row, col, number, depth]
                    queue.offerLast(new int[] {r, c, board[r][c], 1});
                    while (!queue.isEmpty()) {
                        int[] curr = queue.removeFirst();
                        if (curr[3] == 7) {
                            set.add(curr[2]);
                            continue;
                        }
                        for (int[] dir : dirs) {
                            int nx = curr[0] + dir[0];
                            int ny = curr[1] + dir[1];
                            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
                                continue;
                            }
                            int digit = board[nx][ny];
                            queue.offerLast(new int[] {nx, ny, curr[2] * 10 + digit, curr[3] + 1});
                        }
                    }
                }
            }
            sb.append('#').append(testCase).append(' ').append(set.size()).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}