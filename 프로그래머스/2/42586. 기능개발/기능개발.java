import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = speeds.length;
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int max = (int) Math.ceil((100 - progresses[0]) / (double) speeds[0]);
        for (int i = 0; i < n; i++) {
            int days = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            if (max >= days) {
                stack.push(days);
            } else {
                max = days;
                result.add(stack.size());
                stack.clear();
                stack.push(days);
            }
        }
        result.add(stack.size());
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}