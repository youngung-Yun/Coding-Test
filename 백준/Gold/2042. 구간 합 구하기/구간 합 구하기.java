import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        // 펜윅 트리로 구현
        arr = new long[n+1];
        tree = new long[n+1];
        for (int i = 1; i <= n; i++) {
            long number = Long.parseLong(bf.readLine());
            update(i, number);
        }

        for (int i = 0; i < m + k; i++) {
            stk = new StringTokenizer(bf.readLine());
            int command = Integer.parseInt(stk.nextToken());
            long a = Long.parseLong(stk.nextToken());
            long b = Long.parseLong(stk.nextToken());
            if (command == 1) {
                update((int) a, b);
            } else if (command == 2) {
                System.out.println(sum((int) a, (int) b));
            }
        }
    }

    private static long sum(int start, int end) {
        return find(end) - find(start - 1);
    }

    // 파인드: 최하위 1 빼기
    private static long find(int idx) {
        long sum = 0L;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx);
        }

        return sum;
    }

    // 업데이트: 최하위 1 위치에 1 더하기
    private static void update(int idx, long number) {
        long diff = number - arr[idx];
        arr[idx] = number;
        while (idx < tree.length) {
            tree[idx] += diff;
            idx += (idx & -idx);
        }
    }
}
