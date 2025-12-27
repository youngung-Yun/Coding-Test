import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 선물지수
        Map<String, Integer> pointMap = new HashMap<>();
        // 선물 준 횟수
        Map<String, Map<String, Integer>> presentMap = new HashMap<>();
        // 다음 달 선물 받는 개수
        Map<String, Integer> nextMonth = new HashMap<>();
        for (String friend : friends) {
            pointMap.put(friend, 0);
            presentMap.put(friend, new HashMap<>());
            nextMonth.put(friend, 0);
            for (String f : friends) {
                presentMap.get(friend).put(f, 0);
            }
        }
        
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String giver = split[0];
            String reciever = split[1];
            // 선물지수 변경
            pointMap.put(giver, pointMap.get(giver) + 1);
            pointMap.put(reciever, pointMap.get(reciever) - 1);
            // 선물 기록 추가
            Map<String, Integer> giverMap = presentMap.get(giver);
            giverMap.put(reciever, giverMap.get(reciever) + 1);
        }
        
        for (String giver : friends) {
            for (String reciever : friends) {
                int giverCount = presentMap.get(giver).get(reciever);
                int recieverCount = presentMap.get(reciever).get(giver);
                if (giverCount > recieverCount) {
                    nextMonth.put(giver, nextMonth.get(giver) + 1);
                } else if (giverCount == recieverCount) {
                    int giverPoint = pointMap.get(giver);
                    int recieverPoint = pointMap.get(reciever);
                    if (giverPoint > recieverPoint) {
                        nextMonth.put(giver, nextMonth.get(giver) + 1);
                    }
                }
            }
        }
        return nextMonth.values().stream().mapToInt(Integer::intValue).max().getAsInt();
    }
}