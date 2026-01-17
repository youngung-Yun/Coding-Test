import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        Deque<Integer> q1 = new ArrayDeque<>();
        for (int e : queue1) {
            q1.offerLast(e);
            sum1 += e;
        }
        
        long sum2 = 0;
        Deque<Integer> q2= new ArrayDeque<>();
        for (int e : queue2) {
            q2.offerLast(e);
            sum2 += e;
        }
        
        int answer = 0;
        while (sum1 != sum2) {
            if (answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }
            
            if (sum1 > sum2) {
                int removed = q1.removeFirst();
                sum1 -= removed;
                q2.offerLast(removed);
                sum2 += removed;
            } else {
                int removed = q2.removeFirst();
                sum2 -= removed;
                q1.offerLast(removed);
                sum1 += removed;
            }
            ++answer;
        }
        return answer;
    }
}