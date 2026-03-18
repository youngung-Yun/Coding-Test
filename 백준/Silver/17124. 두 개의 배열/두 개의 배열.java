import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            stk = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            int[] a = new int[n];
            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(stk.nextToken());
            }
            int[] b = new int[m];
            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(stk.nextToken());
            }
            Arrays.sort(b);

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = binarySearch(b, m, a[i]);
            }

            long sum = 0L;
            for (int e : ans) {
                sum += e;
            }
            System.out.println(sum);
        }
    }

    private static int binarySearch(int[] arr, int n, int value) {
        int minDiff = 1_000_000_001;
        int result = 0;
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int diff = Math.abs(value - arr[mid]);
            if (diff < minDiff || (diff == minDiff && result > arr[mid])) {
                minDiff = diff;
                result = arr[mid];
            }

            if (arr[mid] > value) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}