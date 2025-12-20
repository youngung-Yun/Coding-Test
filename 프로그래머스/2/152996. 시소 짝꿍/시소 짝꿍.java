import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        // 무게, 사람 수
        Map<Integer, Long> map = new HashMap<>();
        for (int weight: weights) {
            map.put(weight, map.getOrDefault(weight, 0L) + 1L);
        }
        for (int weight: map.keySet()) {
            long people = map.get(weight);
            // 몸무게 같은 경우
            answer += (people * (people - 1L)) / 2L; 
            // 4/2
            if (map.containsKey(weight * 2)) {
                answer += people * map.get(weight * 2);
            }
            // 3/2
            if (weight % 2 == 0 && map.containsKey(weight / 2 * 3)) {
                answer += people * map.get(weight / 2 * 3);
            }
            // 4/3
            if (weight % 3 == 0 && map.containsKey(weight / 3 * 4)) {
                answer += people * map.get(weight / 3 * 4);
            }
        }
        return answer;
    }
}