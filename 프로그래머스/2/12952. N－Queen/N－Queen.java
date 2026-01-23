class Solution {
    
    static int answer = 0;
    
    public int solution(int n) {
        boolean[] colVisited = new boolean[n];
        // (row - col) + (n - 1) = 0 ~ 2n - 1
        boolean[] leftVisited = new boolean[2 * n - 1];
        // (row + col) = 0 ~ 2n - 1
        boolean[] rightVisited = new boolean[2 * n - 1];
        
        bfs(0, colVisited, leftVisited, rightVisited, n);
    
        return answer;
    }
    
    static void bfs(int x, boolean[] col, boolean[] left, boolean[] right, int n) {
        if (x == n) {
            answer += 1;
            return;
        }
        
        for (int y = 0; y < n; y++) {
            // 이미 해당 열 방문
            if (col[y]) {
                continue;
            }
            // 왼쪽 대각선 체크
            if (left[(x - y) + (n - 1)]) {
                continue;
            }
            // 오른쪽 대각선 체크
            if (right[x + y]) {
                continue;
            }
            col[y] = true;
            left[(x - y) + (n - 1)] = true;
            right[x + y] = true;
            bfs(x + 1, col, left, right, n);
            col[y] = false;
            left[(x - y) + (n - 1)] = false;
            right[x + y] = false;
        }
    }
}