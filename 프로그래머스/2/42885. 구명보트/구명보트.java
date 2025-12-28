import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int answer = 0;
        while (left <= right) {
            int totalWeight = people[left] + people[right];
            if (totalWeight <= limit) {
                ++answer;
                ++left;
                --right;
            } else {
                ++answer;
                --right;
            }
        }
        return answer;
    }
}