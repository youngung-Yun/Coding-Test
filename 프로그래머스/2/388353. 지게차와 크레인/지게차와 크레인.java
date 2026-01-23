import java.util.*;

class Solution {
    
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int solution(String[] storage, String[] requests) {
        int row = storage.length;
        int col = storage[0].length();
        
        char[][] warehouse = makeMatrix(storage, row, col);
        boolean[][] isContacted = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            isContacted[i][0] = true;
            isContacted[i][col-1] = true;
        }
        for (int i = 0; i < col; i++) {
            isContacted[0][i] = true;
            isContacted[row-1][i] = true;
        }
        
        for (String request : requests) {
            char container = request.charAt(0);
            
            List<int[]> list = new ArrayList<>();
            if (request.length() == 1) {
                // 최소 한 면이 외부와 맞닿는 컨테이너만 제거
                for (int r = 0; r < row; r++) {
                    for (int c = 0; c < col; c++) {
                        if (warehouse[r][c] == container &&
                            isContacted[r][c]) {
                            warehouse[r][c] = '#';
                            list.add(new int[] {r, c});                                
                        }
                    }
                }
            } else {
                // 해당 컨테이너 모두 제거
                for (int r = 0; r < row; r++) {
                    for (int c = 0; c < col; c++) {
                        if (warehouse[r][c] == container) {
                            warehouse[r][c] = '#';
                            if (isContacted[r][c]) {
                                list.add(new int[] {r, c});                                
                            }
                        }
                    }
                }
            }
            bfs(warehouse, isContacted, list, row, col);
            
        }
        int answer = 0;
        // 남아있는 컨테이너 확인
        for (char[] r : warehouse) {
            for (char c : r) {
                if (c != '#') {
                    answer += 1;
                }
            }
        }
        return answer;
    }
    
    private void bfs(char[][] warehouse, boolean[][] isContacted, List<int[]> starts, int row, int col) {
        // 현재 제거된 컨테이너 근처의 컨테이너들에 flag 체크
        // 그 컨테이너도 제거되었고 isContacted 체크 안되어 있으면 큐에 넣음 
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int[] start : starts) {
            queue.offerLast(start);
        }
        while (!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            for (int[] dir : dirs) {
                int nx = current[0] + dir[0];
                int ny = current[1] + dir[1];
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue;
                }
                if (!isContacted[nx][ny]) {
                    if (warehouse[nx][ny] == '#') {
                        // 제거되었지만 isContacted 체크 안된 컨테이너 큐에 추가
                        queue.offerLast(new int[] {nx, ny});
                    }
                    // 제거된 컨테이너 주변 isContacted 체크
                    isContacted[nx][ny] = true;
                }
            }
        }
    }
    
    private char[][] makeMatrix(String[] storage, int r, int c) {
        char[][] result = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int k = 0; k < c; k++) {
                result[i][k] = storage[i].charAt(k);
            }
        }
        return result;
    }
}