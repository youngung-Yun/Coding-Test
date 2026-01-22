class Solution {
    public int solution(int [][]board) {
        int row = board.length;
        int col = board[0].length;
        
        for (int i = 1; i < row; i++) {
            for (int k = 1; k < col; k++) {
                if (board[i][k] == 1) {
                    board[i][k] = Integer.min(board[i-1][k-1],
                    Integer.min(board[i-1][k], board[i][k-1])) + 1;
                }
            }
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
