import java.util.*;

class Solution {
    
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[] {-1};
        }
        
        return getMultiply(new int[n], 0, n, s);
    }
    
    
    private static int[] getMultiply(int[] arr, int idx, int n, int s) {
        if (n == 0) {
            return arr;
        }
        
        int num = s / n;
        arr[idx] = num;
        return getMultiply(arr, idx + 1, n - 1, s - num);
    }
}