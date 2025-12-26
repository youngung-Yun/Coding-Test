import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] playerCount = new int[N+2];
        for (int stage : stages) {
            ++playerCount[stage];
        }
        int totalPlayer = stages.length;
        PriorityQueue<Stage> pq = new PriorityQueue<>((s1, s2) -> {
            long t1 = (long) s1.stayCount * (long) s2.totalCount;
            long t2 = (long) s2.stayCount * (long) s1.totalCount;
            if (t1 == t2) {
                return Integer.compare(s1.stageNumber, s2.stageNumber);
            } else {
                return Long.compare(t2, t1);
            }
        });
        int[] result = new int[N];
        for (int i = 1; i <= N; i++) {
            pq.add(new Stage(i, totalPlayer, playerCount[i]));
            totalPlayer -= playerCount[i];
        }
        for (int i = 0; i < N; i++) {
            result[i] = pq.poll().stageNumber;
        }
        
        return result;
    }
    
    
    public static class Stage {
        public int stageNumber;
        public int totalCount;
        public int stayCount;
        
        public Stage(int stageNumber, int totalCount, int stayCount) {
            this.stageNumber = stageNumber;
            this.totalCount = totalCount;
            this.stayCount = stayCount;
        }
    }
}

