import java.util.*;

class Solution {
    
    private static String[] vowels = new String[] {"A", "E", "I", "O", "U"};
    private static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs("");
        return list.indexOf(word);
    }
    
    private static void dfs(String current) {
        list.add(current);
        if (current.length() >= 5) {
            return;
        }
        for (String vowel : vowels) {
            dfs(current + vowel);
        }
    }
}