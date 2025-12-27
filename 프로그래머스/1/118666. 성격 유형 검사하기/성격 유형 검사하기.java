import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int n = survey.length;
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for (int i = 0; i < n; i++) {
            char negative = survey[i].charAt(0);
            char positive = survey[i].charAt(1);
            int point = choices[i];
            if (point == 4) {
                continue;
            } else if (point < 4) {
                map.put(negative, map.get(negative) + (4 - point));
            } else {
                map.put(positive, map.get(positive) + (point - 4));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getPersonality('T', map.get('T'), 'R', map.get('R')));
        sb.append(getPersonality('C', map.get('C'), 'F', map.get('F')));
        sb.append(getPersonality('J', map.get('J'), 'M', map.get('M')));
        sb.append(getPersonality('A', map.get('A'), 'N', map.get('N')));
        
        return sb.toString();
    }
    
    private static char getPersonality(char p1, int n1, char p2, int n2) {
        if (n1 == n2) {
            if (Character.compare(p2, p1) > 0) {
                return p1;
            } else {
                return p2;
            }
        } else {
            if (n1 > n2) {
                return p1;
            } else {
                return p2;
            }
        }
    }
}