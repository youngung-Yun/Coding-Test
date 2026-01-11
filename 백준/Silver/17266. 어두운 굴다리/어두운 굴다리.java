import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] streetlights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + ((high - low) / 2);
            // 조건 만족 시 high 이동
            if (canShineWholeStreet(streetlights, mid, n)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }

    static boolean canShineWholeStreet(int[] streetlights, int height, int n) {
        int end = 0;
        for (int streetlight : streetlights) {
            // 불빛이 닿지 않는 곳이 있음
            if (end < streetlight - height) {
                return false;
            }
            end = Integer.max(end, streetlight + height);
        }
        return end >= n;
    }
}