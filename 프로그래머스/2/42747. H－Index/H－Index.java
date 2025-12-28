import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int length = citations.length;
        for (int h = citations[length-1]; h >= 0; --h) {
            int maxCount = 0;
            int minCount = 0;
            for (int citation : citations) {
               maxCount += citation >= h ? 1 : 0;
               minCount += citation <= h ? 1 : 0;
            }
            if (maxCount >= h && minCount <= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}