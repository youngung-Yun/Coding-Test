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
        int[] flowerCount = new int[year];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int startMonth = Integer.parseInt(stk.nextToken());
            int startDay = Integer.parseInt(stk.nextToken());
            int endMonth = Integer.parseInt(stk.nextToken());
            int endDay = Integer.parseInt(stk.nextToken());

            int start = Integer.max(minDay, getDay(startMonth, startDay));
            int end = Integer.min(maxDay, getDay(endMonth, endDay));
            flowers[i] = new int[] {start, end};

            for (int day = start; day < end; day++) {
                ++flowerCount[day];
            }
        }

        Arrays.sort(flowers, (a1, a2) -> Integer.compare(a1[1], a2[1]));

        // 매일 피어있는 것이 가능한지 확인
        for (int day = minDay; day < maxDay; day++) {
            if (flowerCount[day] == 0) {
                System.out.println(0);
                return;
            }
        }
        int ans = n;
        for (int i = 0; i < n; i++) {
            int[] flower = flowers[i];
            if (!canRemove(flowerCount, flower)) {
                continue;
            }
            for (int day = flower[0]; day < flower[1]; day++) {
                --flowerCount[day];
            }
            --ans;
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

    private static boolean canRemove(int[] flowerCount, int[] flower) {
        int start = flower[0];
        int end = flower[1];
        for (int day = start; day < end; day++) {
            if (flowerCount[day] == 1) {
                return false;
            }
        }
        return true;
    }
}
