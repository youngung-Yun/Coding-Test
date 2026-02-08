import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int idx = n - 2;
        while (idx >= 0 && arr[idx] < arr[idx + 1]) {
            --idx;
        }

        if (idx < 0) {
            System.out.println(-1);
            return;
        }

        int swapIdx = n - 1;
        for (int i = n - 1; i > idx; --i) {
            if (arr[idx] > arr[i]) {
                swapIdx = i;
                break;
            }
        }

        swap(idx, swapIdx);

        reverse(idx + 1);

        StringBuilder sb = new StringBuilder();
        for (int e : arr) {
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }

    static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void reverse(int idx) {
        int left = idx;
        int right = n - 1;
        while (left < right) {
            swap(left, right);
            ++left;
            --right;
        }
    }
}