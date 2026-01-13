import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] spendMoneyOfDays = new long[n];
        for (int i = 0; i < n; i++) {
            long money = Long.parseLong(br.readLine());
            spendMoneyOfDays[i] = money;
        }

        long low = 1L;
        long high = 100_000L * 10_000 + 1L;
        while (low <= high) {
            long mid = low + (high - low) / 2L;
            // count는 왼쪽이 크고 오른쪽이 작음
            // mid가 커지면 count는 줄어듦
            if (check(spendMoneyOfDays, mid, m)) {
                high = mid - 1L;
            } else {
                low = mid + 1L;
            }
        }
        System.out.println(low);
    }

    static boolean check(long[] moneys, long withdraw, int limit) {
        long currentMoney = 0L;
        int count = 0;
        for (long money : moneys) {
            if (money > withdraw) {
                return false;
            }
            if (currentMoney < money) {
                ++count;
                currentMoney = withdraw;
            }
            currentMoney -= money;
        }
        return count <= limit;
    }
}