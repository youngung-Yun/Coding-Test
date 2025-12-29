import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 현재 큐에 있으면 빼서 뒤에 삽입, 시간 + 1
        // 큐에 없으면 뒤에 삽입. 시간 + 5
        // 캐시 사이즈 초과하면 맨 앞의 요소 뺌
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        int totalTime = 0;
        Set<String> set = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        for (String city : cities) {
            city = city.toUpperCase();
            if (set.contains(city)) {
                queue.remove(city);
                queue.offerLast(city);
                ++totalTime;
            } else {
                set.add(city);
                queue.offerLast(city);
                totalTime += 5;
            }
            if (cacheSize < queue.size()) {
                set.remove(queue.removeFirst());
            }
        }
        return totalTime;
    }
}