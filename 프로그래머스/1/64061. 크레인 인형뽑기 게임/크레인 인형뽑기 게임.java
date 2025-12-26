import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        List<Deque<Integer>> game = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            game.add(new ArrayDeque<>());
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int x = board[row][col];
                if (x != 0) {
                    game.get(col).push(x);
                } 
            }
        }
        int total = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int col : moves) {
            // 인덱스 보정
            --col;
            if (game.get(col).isEmpty()) {
                continue;
            }
            int doll = game.get(col).pop();
            
            if (stack.isEmpty() || doll != stack.peek()) {
                stack.push(doll);
            } else {
                stack.poll();
                total += 2;
            }
        }
        
        return total;
    }
}