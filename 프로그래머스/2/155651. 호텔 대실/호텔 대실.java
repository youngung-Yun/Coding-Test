class Solution {
    public int solution(String[][] book_time) {
        int[] occupiedCount = new int[24 * 60];
        for (String[] time : book_time) {
            int start = getTime(time[0]);
            int end = Integer.min(getTime(time[1]) + 10, 24 * 60);
            for (int i = start; i < end; i++) {
                ++occupiedCount[i];
            }
        }
        int answer = 0;
        for (int c : occupiedCount) {
            answer = Integer.max(answer, c);
        }
        return answer;
    }
    
    static int getTime(String format) {
        String[] split = format.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        
        return hour * 60 + minute;
    }
}