import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int unused = 1;
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), unused++);
        }

        int pointer = 0;
        StringBuilder sb = new StringBuilder();
        while (pointer < msg.length()) {
            sb.append(msg.charAt(pointer));
            if (map.containsKey(sb.toString())) {
                ++pointer;
                continue;
            }
            result.add(map.get(sb.substring(0, sb.length() - 1)));
            map.put(sb.toString(), unused++);
            sb.setLength(0);
        }
        result.add(map.get(sb.toString()));
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}