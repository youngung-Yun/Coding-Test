import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[] dayOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int year = getDay(13, 0);

        int n = Integer.parseInt(bf.readLine());

        int minDay = getDay(3, 1);
        int maxDay = getDay(12, 1);

        int[][] flowers = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int startMonth = Integer.parseInt(stk.nextToken());
            int startDay = Integer.parseInt(stk.nextToken());
            int endMonth = Integer.parseInt(stk.nextToken());
            int endDay = Integer.parseInt(stk.nextToken());

            int start = getDay(startMonth, startDay);
            int end = getDay(endMonth, endDay);
            flowers[i] = new int[] {start, end};
        }

        Arrays.sort(flowers, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return Integer.compare(a1[1], a2[1]);
            }
            return Integer.compare(a1[0], a2[0]);
        });

        int currentEnd = minDay;
        int ans = 0;
        int idx = 0;
        int maxEnd = 0;

        while (currentEnd < maxDay) {
            boolean found = false;

            // 현재 날짜 이전에 피는 꽃 중 가장 늦게 지는 꽃 선택
            while (idx < n && flowers[idx][0] <= currentEnd) {
                if (maxEnd < flowers[idx][1]) {
                    maxEnd = flowers[idx][1];
                    found = true;
                }
                ++idx;
            }

            if (found) {
                ++ans;
                currentEnd = maxEnd;
            } else {
                System.out.println(0);
                return;
            }
        }

        System.out.println(ans);
    }

    private static int getDay(int month, int day) {
        int result = 0;
        for (int m = 1; m <= month - 1; m++) {
            result += dayOfMonth[m];
        }
        result += day;
        return result;
    }
}
