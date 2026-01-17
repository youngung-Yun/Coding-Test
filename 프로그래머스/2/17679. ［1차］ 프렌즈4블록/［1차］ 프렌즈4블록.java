import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] matrix = new char[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = board[r].charAt(c);
            }
        }
        /*
         * 1. 배열을 순회하며 2x2가 모두 같은 문자인지 확인
            - 'X'는 비어있는 공간으로 같은 문자인지에 대해 포함하지 않음
         * 2. 모두 같은 문자면 그 문자들의 위치를 배열에 넣음
         * 3. 배열을 순회하며 그 문자를 지우고 카운트 증가
            - 지우기 전 그 위치의 문자가 'X'면 그냥 넘어감 (다른 2x2와 겹친 부분임)
         * 4. 배열의 아래부터 순회하며 그 위치의 바로 아래가 다른 문자거나 마지막 행일 때까지 아래로 이동
            - 이동할 때 기존 위치는 'X'로 채움
         * 5. 현재 상황에서 같은 2x2가 없을 때까지 반복
        */
        int answer = 0;
        
        List<int[]> pos = new ArrayList<>();
        while (true) {
            pos.clear();
            for (int r = 0; r < m - 1; r++) {
                for (int c = 0; c < n - 1; c++) {
                    if (matrix[r][c] == 'X') {
                        continue; 
                    }
                    if (canMakeSquare(matrix, r, c)) {
                        pos.add(new int[] {r, c});
                        pos.add(new int[] {r+1, c});
                        pos.add(new int[] {r, c+1});
                        pos.add(new int[] {r+1, c+1});
                    }
                }
            }
            // 더 이상 같은 2x2 블록이 없으면 탈출
            if (pos.size() == 0) {
                break;
            }
            for (int[] p : pos) {
                int x = p[0];
                int y = p[1];
                // 이미 처리한 겹친 부분은 제외
                if (matrix[x][y] == 'X') {
                    continue;
                }
                matrix[x][y] = 'X';
                ++answer;
            }
            dropAllBlocks(matrix, m, n);
        }        
        return answer;
    }
    
    static boolean canMakeSquare(char[][] matrix, int r, int c) {
        return matrix[r][c] == matrix[r+1][c] &&
               matrix[r][c] == matrix[r][c+1] &&
               matrix[r][c] == matrix[r+1][c+1];
    }
    
    static void dropAllBlocks(char[][] matrix, int row, int col) {
        for (int r = row - 1; r >= 0; --r) {
            for (int c = 0; c < col; c++) {
                char block = matrix[r][c];
                int currentRow = r;
                while (currentRow < row - 1 && matrix[currentRow+1][c] == 'X') {
                    // 아래로 떨어짐
                    matrix[currentRow+1][c] = block;
                    matrix[currentRow][c] = 'X';
                    ++currentRow;
                }
            }
        }
    }
}