import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(bf.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            A[i] = Integer.parseInt(stk.nextToken());
            B[i] = Integer.parseInt(stk.nextToken());
            C[i] = Integer.parseInt(stk.nextToken());
            D[i] = Integer.parseInt(stk.nextToken());
        }

        int[] sumAB = sumArray(A, B, n);
        int[] sumCD = sumArray(C, D, n);

        Arrays.sort(sumAB);

        long ans = 0L;
        for (int i = 0; i < n * n; i++) {
            int minIdx = lowerBound(sumAB, n * n, -sumCD[i]);
            int maxIdx = upperBound(sumAB, n * n, -sumCD[i]);
            ans += (maxIdx - minIdx);
        }
        System.out.println(ans);
    }

    private static int lowerBound(int[] arr, int n, int target) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int upperBound(int[] arr, int n, int target) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int[] sumArray(int[] a, int[] b, int n) {
        int[] result = new int[n*n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                result[i*n+k] = a[i] + b[k];
            }
        }
        return result;
    }
}