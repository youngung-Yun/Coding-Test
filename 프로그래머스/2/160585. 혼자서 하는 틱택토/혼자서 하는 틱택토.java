class Solution {
    public int solution(String[] board) {  
        char[][] game = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                game[i][k] = board[i].charAt(k);
            }
        }
        
        int o = 0;
        int x = 0;
        boolean completeO = false;
        boolean completeX = false;
        
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if (game[i][k] == 'O') {
                    o += 1;
                } else if (game[i][k] == 'X') {
                    x += 1;
                }
                // 가로 체크
                if (k == 0) {
                    if (game[i][k] == 'O' && game[i][k+1] == 'O' &&  game[i][k+2] == 'O') {
                        completeO = true;
                    }
                    if (game[i][k] == 'X' && game[i][k+1] == 'X' &&  game[i][k+2] == 'X') {
                        completeX = true;
                    }
                }
                // 세로 체크
                if (i == 0) {
                    if (game[i][k] == 'O' && game[i+1][k] == 'O' &&  game[i+2][k] == 'O') {
                        completeO = true;
                    }
                    if (game[i][k] == 'X' && game[i+1][k] == 'X' &&  game[i+2][k] == 'X') {
                        completeX = true;
                    }
                }
                // 왼쪽 위 대각선 체크
                if (i == 0 && k == 0) {
                    if (game[i][k] == 'O' && game[i+1][k+1] == 'O' &&  game[i+2][k+2] == 'O') {
                        completeO = true;
                    }
                    if (game[i][k] == 'X' && game[i+1][k+1] == 'X' &&  game[i+2][k+2] == 'X') {
                        completeX = true;
                    }
                }
                // 오른쪽 위 대각선 체크
                if (i == 0 && k == 2) {
                    if (game[i][k] == 'O' && game[i+1][k-1] == 'O' &&  game[i+2][k-2] == 'O') {
                        completeO = true;
                    }
                    if (game[i][k] == 'X' && game[i+1][k-1] == 'X' &&  game[i+2][k-2] == 'X') {
                        completeX = true;
                    }
                }
            }
        }
        // 1. O가 X보다 2개 이상 많거나 X가 O보다 1개 이상 많음
        if (o - x >= 2 || x - o >= 1) {
            return 0;
        }
        // 2. 둘다 빙고를 완성함
        if (completeO && completeX) {
            return 0;
        }
        // 3. O가 빙고를 완성했는데 O가 1개 더 많지 않음
        if (completeO && o != x + 1) {
            return 0;
        }
        // 4. X가 빙고를 완성했는데 개수가 같지 않음
        if (completeX && o != x) {
            return 0;
        }
        return 1;
    }
}