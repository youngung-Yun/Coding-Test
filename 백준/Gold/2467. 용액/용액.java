import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] solution = init(bf, n);

        int minDiff = 2_000_000_001;
        int min = 0;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int low = i + 1;
            int high = n;
            while (low < high) {
                int mid = low + (high - low) / 2;
                int sum = solution[mid] + solution[i];
                if (Math.abs(sum) < minDiff) {
                    minDiff = Math.abs(sum);
                    min = solution[i];
                    max = solution[mid];
                }
                if (sum == 0) {
                    break;
                } else if (sum > 0) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        System.out.printf("%d %d", min, max);
    }

    private static int[] init(BufferedReader bf, int n) throws Exception {
        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        return arr;
    }
}