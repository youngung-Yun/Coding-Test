import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(bf.readLine());
        int[] velocity = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            velocity[i] = Integer.parseInt(stk.nextToken());
        }

        long low = velocity[0];
        long high = Long.MAX_VALUE;

        while (low < high) {
            long mid = low + (high - low) / 2L;
            if (canMoveAllPlanet(velocity, n, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }

    private static boolean canMoveAllPlanet(int[] arr, int n, long velocity) {
        for (int i = 0; i < n; i++) {
            if (velocity < arr[i]) {
                return false;
            }
            velocity -= (velocity % arr[i]);
        }
        return true;
    }
}