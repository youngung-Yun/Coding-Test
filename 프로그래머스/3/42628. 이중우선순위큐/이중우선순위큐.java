import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> set = new TreeSet<>();
        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];
            int number = Integer.parseInt(split[1]);
            
            if (command.equals("I")) {
                set.add(number);
            } else if (command.equals("D")) {
                if (set.isEmpty()) {
                    continue;
                }
                if (number == 1) {
                    set.pollLast();
                } else if (number == -1) {
                    set.pollFirst();
                }
            }
        }
        
        if (set.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[] {set.last(), set.first()};
        }
    }
}