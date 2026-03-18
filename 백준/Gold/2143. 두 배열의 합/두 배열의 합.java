import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int t = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        int m = Integer.parseInt(bf.readLine());
        int[] b = new int[m];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(stk.nextToken());
        }

        List<Integer> combA = makeCombinationList(a, n);
        List<Integer> combB = makeCombinationList(b, m);

        long ans = 0L;
        for (int value : combA) {
            int lowIdx = lowerBound(combB, combB.size(), value, t);
            int highIdx = upperBound(combB, combB.size(), value, t);
            ans += (highIdx - lowIdx + 1);
        }
        System.out.println(ans);
    }

    private static List<Integer> makeCombinationList(int[] arr, int n) {
        List<Integer> list = new ArrayList<>();
        for (int s = 0; s < n; s++) {
            int sum = 0;
            for (int e = s; e < n; e++) {
                sum += arr[e];
                list.add(sum);
            }
        }
        list.sort(Comparator.naturalOrder());
        return list;
    }

    private static int lowerBound(List<Integer> list, int n, int value, int target) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int sum = value + list.get(mid);
            if (sum >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int upperBound(List<Integer> list, int n, int value, int target) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int sum = value + list.get(mid);
            if (sum > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }
}