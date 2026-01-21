import java.util.*;

class Solution {
    /*
     * 현재 라운드에서 병사 모자라다 = 현재 라운드 스킵하면 넘어갈 수 있음
       지금까지 클리어한 라운드 중 사람 가장 많은 라운드 스킵하는게 이득
    */
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Round> pq = new PriorityQueue<>((r1, r2) -> Integer.compare(r2.enemy, r1.enemy));
        int idx = 0;
        while (idx < enemy.length) {
            Round curr = new Round(idx, enemy[idx]);
            pq.add(curr);
            n -= enemy[idx];
            if (n < 0) {
                // 병사 모라잔데 스킵 못하면 거기까지
                if (k <= 0) {
                    return idx;
                } else {
                    // 스킵 있으면 스킵
                    Round skip = pq.poll();
                    n += skip.enemy;
                    k -= 1;
                }
            }
            ++idx;
        }
        return idx;
    }


    static class Round {
        public int index;
        public int enemy;

        public Round(int index, int enemy) {
            this.index = index;
            this.enemy = enemy;
        }
    }
}