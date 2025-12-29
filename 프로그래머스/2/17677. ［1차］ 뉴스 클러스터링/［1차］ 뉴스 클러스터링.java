import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        var map1 = getMap(str1);
        var map2 = getMap(str2);
        int intersection = getIntersection(map1, map2);
        int union = getUnion(map1, map2);
        
        if (union == 0) {
            return 1 * 65536;
        }
        return (int) ((1.0 * intersection / union) * 65536);
    }
    
    private static Map<String, Integer> getMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String partial = str.substring(i, i + 2);
            if (!Character.isAlphabetic(partial.charAt(0)) || !Character.isAlphabetic(partial.charAt(1))) {
                continue;
            } 
            map.put(partial, map.getOrDefault(partial, 0) + 1);
        }
        return map;
    }
    
    private static int getIntersection(Map<String, Integer> map1, Map<String, Integer> map2) {
        int result = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                result += Integer.min(map1.get(key), map2.get(key));
            }
        }
        return result;
    }
    
    private static int getUnion(Map<String, Integer> map1, Map<String, Integer> map2) {
        int result = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                result += Integer.max(map1.get(key), map2.get(key));
            } else {
                result += map1.get(key);
            }
        }
        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                result += map2.get(key);
            }
        }
        return result;
    }
}