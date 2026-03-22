import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[][] lectures;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        lectures = new int[n][3];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            int day = Integer.parseInt(stk.nextToken());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            lectures[i] = new int[] {day, start, end};
        }

        // [day, time]
        boolean[][] schedule = new boolean[6][11];
        backtrack(schedule, 0, 0);

        System.out.println(ans);
    }

    static void backtrack(boolean[][] schedule, int sum, int depth) {
        if (sum == k) {
            ++ans;
            return;
        }
        if (depth == n){
             return;
        }

        // depth번 강의 안듣기
        backtrack(schedule, sum, depth + 1);
        // depth번 강의 들을 수 있으면 듣기
        int[] lecture = lectures[depth];
        int day = lecture[0];
        int start = lecture[1];
        int end = lecture[2];
        if (day == 5) {
            return;
        }

        for (int time = start; time <= end; time++) {
            if (schedule[day][time]) {
                return;
            }
        }

        for (int time = start; time <= end; time++) {
            schedule[day][time] = true;
        }
        backtrack(schedule, sum + (end - start + 1), depth + 1);
        for (int time = start; time <= end; time++) {
            schedule[day][time] = false;
        }
    }
}