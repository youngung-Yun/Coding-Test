class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // 벽(#) = 1, 공백 = 0, OR 연산하기
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr1[i] | arr2[i];
        }
        int mask = 0b1 << (n - 1);
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int row = tmp[i];
            for (int k = 0; k < n; k++) {
            	sb.append((row & (mask >>> k)) == 0 ? " " : "#");                
            }
            result[i] = sb.toString();
        }
        return result;
    }
}