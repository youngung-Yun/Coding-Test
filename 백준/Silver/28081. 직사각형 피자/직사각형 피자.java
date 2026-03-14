import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        long w = Long.parseLong(stk.nextToken());
        long h = Long.parseLong(stk.nextToken());
        long k = Long.parseLong(stk.nextToken());

        int n = Integer.parseInt(bf.readLine());
        long[] coordY = new long[n+1];
        long curr = 0L;
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            long y = Long.parseLong(stk.nextToken());
            coordY[i] = y - curr;
            curr = y;
        }
        coordY[n] = h - curr;
        int m = Integer.parseInt(bf.readLine());
        long[] coordX = new long[m+1];
        curr = 0L;
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            long x = Long.parseLong(stk.nextToken());
            coordX[i] = x - curr;
            curr = x;
        }
        coordX[m] = w - curr;

        Arrays.sort(coordY);

        long ans = 0L;
        for (long width : coordX) {
            ans += binarySearch(width, coordY, n + 1, k);
        }
        System.out.println(ans);
    }

    private static int binarySearch(long width, long[] arr, int n, long limit) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (width * arr[mid] <= limit) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}