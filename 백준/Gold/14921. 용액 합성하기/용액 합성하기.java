import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int ans = 200_000_001;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            if (ans == 0) {
                break;
            }
            int idx = binarySearch(arr, i + 1, n, arr[i]);
        }
        System.out.println(ans);
    }

    private static int binarySearch(int[] arr, int left, int right, int value) {
        int low = left;
        int high = right;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int sum = arr[mid] + value;
            if (Math.abs(ans) > Math.abs(sum)) {
                ans = sum;
            }

            if (sum == 0) {
                return mid;
            }
            if (sum > 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}