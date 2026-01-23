import java.util.*;

class Solution {
    public int solution(int[] cards) {
        List<Integer> list = new ArrayList<>();
        
        boolean[] visited = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) {
                continue;
            }
            int count = 0;
            int currentIdx = i;
            while (!visited[currentIdx]) {
                visited[currentIdx] = true;
                currentIdx = cards[currentIdx] - 1;
                count += 1;
            }
            list.add(count);
        }
        
        if (list.size() == 1) {
            return 0;
        }
        
        int answer = list.stream()
            .sorted(Comparator.reverseOrder())
            .limit(2).reduce(1, (a, b) -> a * b);
        return answer;
    }
}