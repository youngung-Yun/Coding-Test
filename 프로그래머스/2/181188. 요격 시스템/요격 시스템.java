import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        /*
        1. 시작 지점 순으로 정렬
        2. 직선 하나 꺼내서 요격 횟수 + 1
        3. 그 직선과 겹치는 부분이 있는 직선은 한 번에 요격 가능 (끝 부분과 같으면 안됨)
        4. 다시 2번부터
        */
        PriorityQueue<Missile> pq = new PriorityQueue<>(
            (m1, m2) -> {
                if (m1.s == m2.s) {
                    return Integer.compare(m1.e, m2.e);
                }
                return Integer.compare(m1.s, m2.s);
            });
        
        for (int[] target : targets) {
            pq.add(new Missile(target[0], target[1]));
        }
        
        int answer = 0;
        while (!pq.isEmpty()) {
            Missile current = pq.poll();
            int right = current.e;
            answer += 1;
            while (!pq.isEmpty() && right > pq.peek().s) {
                right = Integer.min(right, pq.peek().e);
                pq.poll();
                
            }
        }
        return answer;
    }
    
    static class Missile {
        public int s;
        public int e;
        
        public Missile(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}