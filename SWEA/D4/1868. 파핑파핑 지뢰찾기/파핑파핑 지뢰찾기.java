import java.util.*;
import java.io.FileInputStream;

class Solution
{
    private static int[][] around = new int[][] {{-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {1, 0}, {1, 1}, {1, -1}};

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            char[][] board = new char[n][n];
            for (int row = 0; row < n; ++row) {
                String line = sc.next();
                for (int col = 0; col < n; ++col) {
                    board[row][col] = line.charAt(col);
                }
            }
            boolean[][] visited = new boolean[n][n];
            // 1. 0인 칸(근처에 지뢰가 없는 칸)들을 클릭하여 적은 횟수로 최대한 숫자를 많이 표시함
            // 2.  0칸과 이어져 있지 않은 나머지 칸들은 한 칸당 한 번씩 클릭해야 함
            int answer = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (board[row][col] == '*') {
                        continue;
                    }
                    if (visited[row][col]) {
                        continue;
                    }
                    if (getAroundMineCount(board, row, col, n) > 0) {
                        continue;
                    }
					// 1                    
                    ++answer;
                    Deque<int[]> queue = new ArrayDeque<>();
                    queue.offerLast(new int[] {row ,col});
                    visited[row][col] = true;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.removeFirst();
                        int x = curr[0];
                        int y = curr[1];
                        int mineCount = getAroundMineCount(board, x, y, n);
                        if (mineCount > 0) {
                            continue;
                        }
                        for (int[] delta : around) {
                            int dx = x + delta[0];
                            int dy = y + delta[1];
                            if (dx < 0 || dy < 0 || dx >= n || dy >=n) {
                                continue;
                            }
                            if (board[dx][dy] == '*' || visited[dx][dy]) {
                                continue;
                            }
                            queue.offerLast(new int[] {dx, dy});
                            visited[dx][dy] = true;
                        }
                    }
                }
            }
			// 2            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (board[row][col] == '*' || visited[row][col]) {
                        continue;
                    }
                    ++answer;
                }
            }
            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static int getAroundMineCount(char[][] board, int row, int col, int n) {
        int count = 0;
        for (int[] delta : around) {
            int dx = row + delta[0];
            int dy = col + delta[1];
            if (dx < 0 || dy < 0 || dx >= n || dy >= n) {
                continue;
            }
            if (board[dx][dy] == '*') {
                ++count;
            }
        }
        return count;
    }
}