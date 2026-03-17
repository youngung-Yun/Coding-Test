class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int range = w * 2 + 1;
        
        int currentEnd = 0;
        for (int station : stations) {
            int start = station - w;
            int end = station + w;
            if (start <= currentEnd) {
                currentEnd = Integer.max(currentEnd, end);
            } else {
                int space = start - currentEnd - 1;
                answer += space / range;
                if (space % range != 0) {
                    ++answer;
                }
                currentEnd = end;
            }
        }
        
        if (currentEnd < n) {
            int space = n - currentEnd;
            answer += space / range;
            if (space % range != 0) {
                ++answer;
            }
        }
        
        return answer;
    }
}