import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = Integer.parseInt(bf.readLine());
        }

        int low = 1;
        int high = 1_000_000_001;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canMakeKimbap(length, k, m, mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(low - 1 == 0 ? -1 : low - 1);
    }

    private static boolean canMakeKimbap(int[] arr, int remove, int minCount, int size) {
        int count = 0;
        for (int length : arr) {
            int curr = length;
            if (curr <= remove || curr == 2 * remove) {
                continue;
            } else if (curr < 2 * remove) {
                curr -= remove;
            } else {
                curr -= remove * 2;
            }
            count += (curr / size);
        }

        return count >= minCount;
    }
}