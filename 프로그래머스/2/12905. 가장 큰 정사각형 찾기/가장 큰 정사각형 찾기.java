class Solution {
    public int solution(int [][]board) {
        int row = board.length;
        int col = board[0].length;
        
        int start = 1;
        while (start < row && start < col) {
            // 가로 채우기
            for (int i = start; i < col; i++) {
                if (board[start][i] == 1) {
                    board[start][i] = Integer.min(board[start-1][i-1],
                    Integer.min(board[start-1][i], board[start][i-1])) + 1;
                }
            }
            // 세로 채우기
            for (int i = start; i < row; i++) {
                if (board[i][start] == 1) {
                    board[i][start] = Integer.min(board[i-1][start-1],
                   Integer.min(board[i-1][start], board[i][start-1])) + 1;
                }
            }
            start += 1;
        }
        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                answer = Integer.max(answer, board[i][k]);
            }
        }
        return answer * answer;
    }
}