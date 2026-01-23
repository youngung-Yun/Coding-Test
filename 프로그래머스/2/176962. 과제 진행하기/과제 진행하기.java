import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        Homework[] homeworks = new Homework[n];
        for (int i = 0; i < n; i++) {
            String[] plan = plans[i];
            homeworks[i] = new Homework(plan[0], format(plan[1]), Integer.parseInt(plan[2]));
        }
        Arrays.sort(homeworks);
        
        String[] answer = new String[n];
        int index = 0;

        Deque<Homework> stack = new ArrayDeque<>();

        Homework current = homeworks[0];
        for (int i = 1; i < n; i++) {
            Homework next = homeworks[i];
            // 시간 같거나 남음
            if (current.start + current.remain <= next.start) {
                answer[index] = current.subject;
                index += 1;

                int spareTime = next.start - (current.start + current.remain);
                // 남는 시간동안 중단했던 과제 하기
                while (!stack.isEmpty() && spareTime > 0) {
                    Homework latest = stack.pop();
                    if (latest.remain <= spareTime) {
                        spareTime -= latest.remain;
                        answer[index] = latest.subject;
                        index += 1;
                    } else {
                        latest.remain -= spareTime;
                        stack.push(latest);
                        spareTime = 0;
                    }
                }
                current = next;
            } else {
                // 중간에 멈춰야 함
                int diff = next.start - current.start;
                current.remain -= diff;
                stack.push(current);
                //
                current = next;
            }
        }

        answer[index] = current.subject;
        index += 1;

        while (!stack.isEmpty()) {
            answer[index] = stack.pop().subject;
            index += 1;
        }

        return answer;
    }

    static class Homework implements Comparable<Homework> {
        public String subject;
        public int start;
        public int remain;

        public Homework(String subject, int start, int remain) {
            this.subject = subject;
            this.start = start;
            this.remain = remain;
        }
        
        @Override
        public int compareTo(Homework other) {
            return Integer.compare(this.start, other.start);
        }
    }

    static int format(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return hour * 60 + minute;
    }
}