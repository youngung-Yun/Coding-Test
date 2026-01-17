class Solution {
    
    static int[] counts = new int[2];
    
    public int[] solution(int[][] arr) {
        quadCompression(arr, 0, 0, arr.length);
        return counts;
    }
    
    static void quadCompression(int[][] arr, int x, int y, int n) {
        int value = arr[x][y];
        boolean isSame = true;
        for (int r = x; r < x + n; r++) {
            if (!isSame) {
                break;
            }
            for (int c = y; c < y + n; c++) {
                if (arr[r][c] != value) {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) {
            ++counts[value];
            return;
        }
        int half = n / 2;
        quadCompression(arr, x, y, half);
        quadCompression(arr, x + half, y, half);
        quadCompression(arr, x, y + half, half);
        quadCompression(arr, x + half, y + half, half);
        
    }
}