import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private final static long MOD = 1_000_000_007L;
    private static long[] segment;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        long[] arr = new long[n];
        segment = new long[n*4];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(bf.readLine());
        }

        buildSegmentTree(arr, 1, 0, n - 1);

        for (int query = 0; query < m + k; query++) {
            stk = new StringTokenizer(bf.readLine());
            long a = Long.parseLong(stk.nextToken());
            long b = Long.parseLong(stk.nextToken());
            long c = Long.parseLong(stk.nextToken());

            // 값 변경
            if (a == 1L) {
                update(1, 0, n - 1, (int) (b - 1), c);
                arr[(int) (b - 1)] = c;
            // 구갑 곱 구하기
            } else if (a == 2L) {
                System.out.println(query(1, 0, n - 1, (int) (b - 1), (int) (c - 1)));
            }
        }
    }

    private static long query(int current, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return 1L;
        }
        if (start >= left && end <= right) {
            if (segment[current] == 0) {
            }
            return segment[current];
        }

        int mid = start + (end - start) / 2;

        return (query(current * 2, start, mid, left, right) * (query(current * 2 + 1, mid + 1, end, left, right))) % MOD;
    }

    private static void buildSegmentTree(long[] array, int current, int start, int end) {
        if (start == end) {
            segment[current] = array[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildSegmentTree(array, current * 2, start, mid);
        buildSegmentTree(array, current * 2 + 1, mid + 1, end);

        segment[current] = (segment[current*2] * segment[current*2+1]) % MOD;
    }

    private static void update(int current, int start, int end, int idx, long newValue) {
        if (start == end) {
            segment[current] = newValue;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(current * 2, start, mid, idx, newValue);
        } else {
            update(current * 2 + 1, mid + 1, end, idx, newValue);
        }

        segment[current] = (segment[current*2] * segment[current*2+1]) % MOD;
    }
}
