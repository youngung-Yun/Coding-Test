class Solution {
    
    private static int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        // 1. 1부터 n까지 5개를 선택한 조합들을 구함
        // 2. 그 조합이 모든 입력에 대해 일치하는 개수가 같은지 확인
        // 3. 같으면 answer 1 증가
        bfs(new int[5], 0, n, 1, q, ans);
        return answer;
    }
    
    private void bfs(int[] arr, int depth, int n, int curr, int[][] q, int[] ans) {
        if (depth == 5) {
            if (isCorrectCode(arr, q, ans)) {
                answer += 1;
            }
            return;
        }
        for (int i = curr; i <= n; i++) {
            arr[depth] = i;
            bfs(arr, depth + 1, n, i + 1, q, ans);
        }
    }
    
    private boolean isCorrectCode(int[] arr, int[][] q, int[] ans) {
        for (int i = 0; i < ans.length; i++) {
            int[] question = q[i];
            int answer = ans[i];
            
            int count = 0;
            for (int n : arr) {
                for (int e : question) {
                    if (n == e) {
                        count += 1;
                        break;
                    }
                }
            }
            if (count != answer) {
                return false;
            }
        }
        return true;
    }
}