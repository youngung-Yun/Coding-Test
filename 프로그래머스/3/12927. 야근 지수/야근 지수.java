import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }
        
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                break;
            }
            int work = pq.poll();
            if (work - 1 > 0) {
                pq.add(work - 1);
            }
        }
        
        if (pq.isEmpty()) {
            return 0L;
        }
        long ans = 0L;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            ans += (work * work);
        }
        return ans;
    }
}