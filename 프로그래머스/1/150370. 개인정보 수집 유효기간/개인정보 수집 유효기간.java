import java.util.*;

class Solution {
    public int[] solution(String todayFormat, String[] terms, String[] privacies) {
        // 만료일이 현재 날짜와 같거나 과거면 파기
        // 만료일이 현재 날짜보다 미래면 파기안함
        Date today = Date.of(todayFormat);
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] tmp = term.split(" ");
            termsMap.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] splitted = privacies[i].split(" ");
            Date endDate = Date.of(splitted[0]);
            endDate.plusMonth(termsMap.get(splitted[1]));
            if (!endDate.isAfterThan(today)) {
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static class Date {
        public int year;
        public int month;
        public int day;
        
        private Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        
        public boolean isAfterThan(Date other) {
            if (this.year > other.year) {
                return true;
            } else if (this.year < other.year) {
                return false;
            } else if (this.month > other.month) {
                return true;
            } else if (this.month < other.month) {
                return false;
            } else if (this.day > other.day) {
                return true;
            } else {
                return false;
            }
            
        }
        
        public void plusMonth(int plusMonth) {
            int added = this.month + plusMonth;
            while (added > 12) {
                added -= 12;
                ++year;
            }
            this.month = added;
        }
        
        public static Date of(String dateFormat) {
            String[] parsed = dateFormat.split("\\.");
            int year = Integer.parseInt(parsed[0]);
            int month = Integer.parseInt(parsed[1]);
            int day = Integer.parseInt(parsed[2]);
            return new Date(year, month, day);
        }
    }
}