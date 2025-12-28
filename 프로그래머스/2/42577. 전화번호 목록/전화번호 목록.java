import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparing(String::length));
        Set<String> numberSet = new HashSet<>();
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                String partial = number.substring(0, i);
                if (numberSet.contains(partial)) {
                    return false;
                }
            }
            numberSet.add(number);
        }
        
        return true;
    }
}