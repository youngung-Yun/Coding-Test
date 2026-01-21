import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {        
        String answer = "(None)";
        int answerLength = 0;
        m = replaceSemitone(m);
        
        for (String musicInfo : musicinfos) {
            StringTokenizer st = new StringTokenizer(musicInfo, ",");
            int startTime = getMinute(st.nextToken());
            int endTime = getMinute(st.nextToken());

            int duration = endTime - startTime;
            String title = st.nextToken();
            String melody = st.nextToken();
            melody = replaceSemitone(melody);
            
            int length = melody.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < duration; i++) {
                sb.append(melody.charAt(i % length));
            }
            
            // 조건 일치
            if (sb.toString().contains(m)) {
                // 크기 비교
                if (duration > answerLength) {
                    answer = title;
                    answerLength = duration;
                }
            }
        }
        return answer;
    }
    
    static String replaceSemitone(String melody) {
        Map<String, String> replace = new HashMap<>();
        replace.put("C#", "T");
        replace.put("D#", "U");
        replace.put("E#", "V");
        replace.put("F#", "W");
        replace.put("G#", "X");
        replace.put("A#", "Y");
        replace.put("B#", "Z");
        
        for (String note : replace.keySet()) {
            melody = melody.replaceAll(note, replace.get(note));
        }
        return melody;
    }
    
    static int getMinute(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        
        return hour * 60 + minute;
    }
}