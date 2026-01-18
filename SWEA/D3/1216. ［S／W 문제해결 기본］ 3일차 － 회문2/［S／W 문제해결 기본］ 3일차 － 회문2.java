import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int WIDTH = 100;
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; testCase++) {
            int t = Integer.parseInt(br.readLine());
            char[][] board = new char[WIDTH][WIDTH];
            for (int i = 0; i < WIDTH; i++) {
                String row = br.readLine();
                for (int k = 0; k < WIDTH; k++) {
                    board[i][k] = row.charAt(k);
                }
            }
            int answer = 0;
            for (int r = 0; r < WIDTH; r++) {
                for (int c = 0; c < WIDTH; c++) {
                    answer = Integer.max(answer, findPalindrome(board, r, c, WIDTH, WIDTH));
                }
            }
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    // 1. 현재 위치로부터 k만큼 떨어진 문자가 서로 같은지 계속 비교 (회문의 길이가 홀수인 경우)
    // 2. 현재 위치 a와 a+1이 같은 경우, a - k와 a + 1 + k가 같은지 계속 비교 (회문의 길이가 짝수인 경우)
    static int findPalindrome(char[][] board, int x, int y, int r, int c) {
        int longest = 0;
        // 세로 홀수 길이 펠린드롬
        int up = x - 1;
        int down = x + 1;
        int count = 1;
        while (up >= 0 && down < r && board[up][y] == board[down][y]) {
            --up;
            ++down;
            count += 2;
        }
        longest = Integer.max(longest, count);
        // 가로 홀수 길이 펠린드롬
        int left = y - 1;
        int right = y + 1;
        count = 1;
        while (left >= 0 && right < c && board[x][left] == board[x][right]) {
            --left;
            ++right;
            count += 2;
        }
        longest = Integer.max(longest, count);
        // 세로 짝수 길이 펠린드롬
        up = x;
        down = x + 1;
        count = 0;
        while (up >= 0 && down < r && board[up][y] == board[down][y]) {
            --up;
            ++down;
            count += 2;
        }
        longest = Integer.max(longest, count);
        // 가로 짝수 길이 펠린드롬
        left = y;
        right = y + 1;
        count = 0;
        while (left >= 0 && right < c && board[x][left] == board[x][right]) {
            --left;
            ++right;
            count += 2;
        }
        longest = Integer.max(longest, count);
        return longest;
    }
}