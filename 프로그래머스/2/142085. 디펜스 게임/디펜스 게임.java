import java.util.*;

class Solution {
    /*
     * 현재 라운드에서 병사 모자라다 = 현재 라운드 스킵하면 넘어갈 수 있음
       지금까지 클리어한 라운드 중 사람 가장 많은 라운드 스킵하는게 이득
    */
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int round = 0;
        while (round < enemy.length) {
            pq.add(enemy[round]);
            n -= enemy[round];
            if (n < 0) {
                // 병사 모라잔데 스킵 못하면 거기까지
                if (k <= 0) {
                    return round;
                } else {
                    // 스킵 있으면 스킵
                    int e = pq.poll();
                    n += e;
                    k -= 1;
                }
            }
            ++round;
        }
        return round;
    }
}
