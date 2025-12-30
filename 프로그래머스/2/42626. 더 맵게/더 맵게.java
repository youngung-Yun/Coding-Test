import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int hot : scoville) {
            pq.add(hot);
        }
        int answer = 0;
        while (pq.peek() < K) {
            if (pq.size() <= 1) {
                answer = -1;
                break;
            }
            pq.add(pq.poll() + (pq.poll() * 2));
            ++answer;
        }
        return answer;
    }
}