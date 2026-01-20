import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] board = new char[h][w];
            for (int row = 0; row < h; row++) {
                String r = br.readLine();
                for (int col = 0; col < w; col++) {
                    board[row][col] = r.charAt(col);
                }
            }
            int answer = paint(board, h, w);
            System.out.println(answer);
        }
        System.out.println(sb);
    }


    static int paint(char[][] board, int h, int w) {
        int count = 0;
        for (int row = 0; row < h; row++) {
            boolean hasLine = true;
            for (int col = 0; col < w; col++) {
                if (board[row][col] != '#') {
                    hasLine = false;
                    break;
                }
            }
            if (hasLine) {
                ++count;
            }
        }
        // 모든 행을 칠했다 = 격자판 전체가 검은색으로 칠해짐
        // 이 경우 h와 w중 작은 값 만큼만 칠하면 됨
        if (count == h) {
            return Integer.min(h, w);
        }
        for (int col = 0; col < w; col++) {
            boolean hasLine = true;
            for (int row = 0; row < h; row++) {
                if (board[row][col] != '#') {
                    hasLine = false;
                    break;
                }
            }
            if (hasLine) {
                ++count;
            }
        }
        return count;
    }
}