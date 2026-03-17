import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        int[][] tasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            tasks[i] = new int[] {jobs[i][0], jobs[i][1], i};
        }
        Arrays.sort(tasks, (t1, t2) -> Integer.compare(t1[0], t2[0]));

        // [요청시간, 소요시간, 번호]
        PriorityQueue<int[]> pq = new PriorityQueue<>((t1, t2) -> {
            if (t1[1] != t2[1]) {
                return Integer.compare(t1[1], t2[1]);
            }
            if (t1[0] != t2[0]) {
                return Integer.compare(t1[0], t2[0]);
            }
            return Integer.compare(t1[2], t2[2]);
        });
        
        int ans = 0;
        int current = 0;
        int count = 0;
        int idx = 0;
        while (count < n) {
            // 큐가 비어있으면 남은 작업 중 가장 요청시간이 먼저인 작업까지 대기
            if (pq.isEmpty()) {
                current = Integer.max(current, tasks[idx][0]);
            } 
            while (idx < n && tasks[idx][0] <= current) {
                pq.add(tasks[idx]);
                ++idx;
            } 
            
            int[] now = pq.poll();
            current += now[1];
            ans += (current - now[0]);
            ++count; 
        }
        
        return ans / n;
    }
}