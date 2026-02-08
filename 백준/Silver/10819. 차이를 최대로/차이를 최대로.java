import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int ans = 0;
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

        findPermutation(0);

        System.out.println(ans);
    }

    static void findPermutation(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(arr[i] - arr[i+1]);
            }
            ans = Integer.max(ans, sum);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(depth, i);
            findPermutation(depth + 1);
            swap(depth, i);
        }
    }

    static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}