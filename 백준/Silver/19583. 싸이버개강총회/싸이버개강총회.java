import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Time meetingStartTime = new Time(st.nextToken());
        Time meetingendTime = new Time(st.nextToken());
        Time streamingEndTime = new Time(st.nextToken());

        Set<String> entrySet = new HashSet<>();
        Set<String> exitSet = new HashSet<>();

        while (true) {
            String input = br.readLine();
            if (input == null || input.isBlank()) {
                break;
            }
            String[] log = input.split(" ");
            Time chattingTime = new Time(log[0]);
            String name = log[1];
            if (chattingTime.isBeforeOrEqualThen(meetingStartTime)) {
                entrySet.add(name);
            } else if (chattingTime.isAfterOrEqualThen(meetingendTime) && chattingTime.isBeforeOrEqualThen(streamingEndTime)) {
                exitSet.add(name);
            }
        }

        int result = (int) entrySet.stream().filter(s -> exitSet.contains(s)).count();
        System.out.println(result);
    }

    private static class Time {
        public int hour;
        public int second;

        public Time(String format) {
            String[] split = format.split(":");
            hour = Integer.parseInt(split[0]);
            second = Integer.parseInt(split[1]);
        }

        public boolean isBeforeOrEqualThen(Time other) {
            if (this.hour < other.hour) {
                return true;
            } else if (this.hour > other.hour) {
                return false;
            } else {
                if (this.second <= other.second) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        public boolean isAfterOrEqualThen(Time other) {
            if (this.hour > other.hour) {
                return true;
            } else if (this.hour < other.hour) {
                return false;
            } else {
                if (this.second >= other.second) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}