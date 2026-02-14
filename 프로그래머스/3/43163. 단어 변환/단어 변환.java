import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        // 방문 처리 + 변환 횟수 카운팅
        Map<String, Integer> changeCount = new HashMap<>();
        
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        changeCount.put(begin, 0);
        while (!queue.isEmpty() && !changeCount.containsKey(target)) {
            String curr = queue.remove();
            for (String word : words) {
                if (changeCount.containsKey(word)) {
                    continue;
                }
                if (!canChange(curr, word)) {
                    continue;
                }
                queue.offer(word);
                changeCount.put(word, changeCount.get(curr) + 1);
            }
        }
        
        return changeCount.containsKey(target) ? changeCount.get(target) : 0;
    }
    
    public boolean canChange(String curr, String target) {
        int diff = 0;
        for (int i = 0; i < curr.length(); i++) {
            diff += curr.charAt(i) != target.charAt(i) ? 1 : 0;
        }
        return diff == 1;
    }
}