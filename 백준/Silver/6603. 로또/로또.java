import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static int[] mask;
    static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            k = Integer.parseInt(stk.nextToken());
            if (k == 0) {
                break;
            }

            nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(stk.nextToken());
            }

            mask = new int[k];
            for (int i = 0; i < 6; i++) {
                mask[i] = 1;
            }

            while (findPermutation()) {}

            sb.append('\n');
        }
        System.out.println(sb);
    }

    static boolean findPermutation() {
        printPermutation();

        int idx = k - 2;
        while (idx >= 0 && mask[idx] <= mask[idx + 1]) {
            --idx;
        }

        if (idx < 0) {
            return false;
        }

        for (int i = k - 1; i > idx; i--) {
            if (mask[i] < mask[idx]) {
                swap(i, idx);
                break;
            }
        }

        reverse(idx + 1);

        return true;
    }

    static void printPermutation() {
        for (int i = 0; i < k; i++) {
            if (mask[i] == 1) {
                sb.append(nums[i]).append(' ');
            }
        }
        sb.append('\n');
    }

    static void swap(int a, int b) {
        int tmp = mask[a];
        mask[a] = mask[b];
        mask[b] = tmp;
    }

    static void reverse(int left) {
        int right = k - 1;
        while (left < right) {
            swap(left, right);
            ++left;
            --right;
        }
    }
}