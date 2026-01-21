import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        k -= 1;
        long f = getFactorial(n);
        for (int i = 0; i < n; i++) {
            f = f / (n - i);
            int number = ((int) (k / f));
            answer[i] = list.get(number);
            list.remove(number);
            k %= f;
        }

        return answer;
    }

    static long getFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}