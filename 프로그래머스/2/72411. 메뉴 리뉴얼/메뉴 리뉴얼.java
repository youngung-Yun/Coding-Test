import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            char[] charArray = order.toCharArray();
            Arrays.sort(charArray);
            bfs(charArray, "", 0, order.length(), course);
        }
        
        List<String> result = new ArrayList<>();
        for (int c : course) {
            int maxCount = 0;
            List<String> tmp = new ArrayList<>();
            for (String key : map.keySet()) {
                if (key.length() != c) {
                    continue;
                }
                int count = map.get(key);
                if (count < 2) {
                    continue;
                }
                
                if (count == maxCount) {
                    tmp.add(key);
                } else if (count > maxCount) {
                    maxCount = count;
                    tmp.clear();
                    tmp.add(key);
                }
            }
            for (String s : tmp) {
                result.add(s);
            }
        }
        result.sort(Comparator.naturalOrder());
        return result.toArray(new String[0]);
    }
    
    static void bfs(char[] array, String current, int depth, int n, int[] needCount) {
        if (depth >= n) {
            // 조합을 이루는 단품의 개수가 course 중에 있어야 map에 추가
            for (int c : needCount) {
                if (current.length() == c) {
                map.put(current, map.getOrDefault(current, 0) + 1);
                break;
                }
            }
            return;
        }

        // depth번 단품을 조합에 넣기 & 안넣기
        bfs(array, current + array[depth], depth + 1, n, needCount);
        bfs(array, current, depth + 1, n, needCount);
    }
}