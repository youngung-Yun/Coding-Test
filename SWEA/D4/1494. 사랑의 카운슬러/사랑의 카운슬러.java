import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

    static long ans;
    static int n;
    static int[] arr;
    static int[][] worms;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            ans = -1L;
            worms = new int[n][2];
            for (int i = 0; i < n; i++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                worms[i] = new int[] {x, y};
            }

            arr = new int[n];
            for (int i = 0; i < n / 2; i++) {
                arr[n-1-i] = 1;
            }

            while (nextPermutation()) {}

            sb.append('#').append(tc).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    private static void compute() {
        long tx = 0L;
        long ty = 0L;
        for (int i = 0; i < n; i++) {
            int isStart = arr[i];
            if (isStart == 0) {
                tx += worms[i][0];
                ty += worms[i][1];
            } else {
                tx -= worms[i][0];
                ty -= worms[i][1];
            }
        }

        long vector = tx * tx + ty * ty;
        if (ans == -1 || ans > vector) {
            ans = vector;
        }
    }

    private static boolean nextPermutation() {
        compute();

        int idx = n - 2;
        while (idx >= 0 && arr[idx] >= arr[idx+1]) {
            --idx;
        }

        if (idx < 0) {
            return false;
        }

        int changeIdx = n - 1;
        while (arr[idx] >= arr[changeIdx]) {
            --changeIdx;
        }

        swap(idx, changeIdx);

        int left = idx + 1;
        int right = n - 1;
        while (left < right) {
            swap(left, right);
            ++left;
            --right;
        }

        return true;
    }

    private static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}