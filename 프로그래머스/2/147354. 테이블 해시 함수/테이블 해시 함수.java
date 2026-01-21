import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (d1, d2) -> {
            if (d1[col-1] == d2[col-1]) {
                return Integer.compare(d2[0], d1[0]);
            }
            return Integer.compare(d1[col-1], d2[col-1]);
        });

        int bitwise = 0;
        for (int i = row_begin ; i <= row_end; i++) {
            int sum = 0;
            int[] row = data[i-1];
            for (int value : row) {
                sum += (value % i);
            }
            bitwise ^= sum;
        }
        
        return bitwise;
    }
}