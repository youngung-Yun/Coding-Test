import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MIN = 0;
    final static int MAX = 1_000_000_001;

    static int n;
    static int[] arr;
    static int[] minTree;
    static int[] maxTree;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        buildMinTree();
        buildMaxTree();

        StringBuilder sb = new StringBuilder();
        for (int query = 0; query < m; query++) {
            stk = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            int min = queryMin(start, end);
            int max = queryMax(start, end);
            sb.append(min).append(' ').append(max).append('\n');
        }

        System.out.println(sb);
    }

    private static void buildMinTree() {
        minTree = new int[n * 4];
        buildMinTree(1, 1, n);
    }

    private static void buildMinTree(int current, int start, int end) {
        if (start == end) {
            minTree[current] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildMinTree(current * 2, start, mid);
        buildMinTree(current * 2 + 1, mid + 1, end);
        minTree[current] = Integer.min(minTree[current*2], minTree[current*2+1]);
    }

    private static void buildMaxTree() {
        maxTree = new int[n * 4];
        buildMaxTree(1, 1, n);
    }

    private static void buildMaxTree(int current, int start, int end) {
        if (start == end) {
            maxTree[current] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildMaxTree(current * 2, start, mid);
        buildMaxTree(current * 2 + 1, mid + 1, end);
        maxTree[current] = Integer.max(maxTree[current*2], maxTree[current*2+1]);
    }

    private static int queryMin(int left, int right) {
        return queryMin(1, 1, n, left, right);
    }

    private static int queryMin(int current, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return MAX;
        }
        if (start >= left && end <= right) {
            return minTree[current];
        }

        int mid = start + (end - start) / 2;
        return Integer.min(queryMin(current * 2, start, mid, left, right), queryMin(current * 2 + 1, mid + 1, end, left, right));
    }

    private static int queryMax(int left, int right) {
        return queryMax(1, 1, n, left, right);
    }

    private static int queryMax(int current, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return MIN;
        }
        if (start >= left && end <= right) {
            return maxTree[current];
        }

        int mid = start + (end - start) / 2;
        return Integer.max(queryMax(current * 2, start, mid, left, right), queryMax(current * 2 + 1, mid + 1, end, left, right));
    }
}