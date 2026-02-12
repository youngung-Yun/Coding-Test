import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    final static int MAX = 40_000;

    static int ans;
    static int n;
    static int[][] synergies;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testcase = 1; testcase <= t; testcase++) {
            ans = MAX;
            n = Integer.parseInt(bf.readLine());
            synergies = new int[n][n];
            for (int r = 0; r < n; r++) {
                StringTokenizer stk = new StringTokenizer(bf.readLine());
                for (int c = 0; c < n; c++) {
                    synergies[r][c] = Integer.parseInt(stk.nextToken());
                }
            }

            int[] combination = new int[n];
            for (int i = 0; i < n / 2; i++) {
                combination[n-1-i] = 1;
            }

            // nC(n/2)인 조합 구하기
            while (nextPermutation(combination)) {

            }
            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static boolean nextPermutation(int[] array) {
        ans = Integer.min(ans, computeTasteDifference(array));

        int idx = n - 2;
        while (idx >= 0 && array[idx] >= array[idx+1]) {
            --idx;
        }

        if (idx < 0) {
            return false;
        }

        for (int swapIdx = n - 1; swapIdx > idx; swapIdx--) {
            if (array[idx] < array[swapIdx]) {
                swap(array, idx, swapIdx);
                break;
            }
        }

        reverse(array, idx + 1);

        return true;
    }

    static int computeTasteDifference(int[] array) {
        int idx1 = 0;
        int idx2 = 0;
        int[] ingredients1 = new int[n/2];
        int[] ingredients2 = new int[n/2];

        for (int i = 0; i < n; i++) {
            if (array[i] == 0) {
                ingredients1[idx1++] = i;
            } else {
                ingredients2[idx2++] = i;
            }
        }

        int diff = Math.abs(makeFood(ingredients1) - makeFood(ingredients2));
        return diff;
    }

    static int makeFood(int[] ingredients) {
        int totalSynergy = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i + 1; j < n / 2; j++) {
                int ingredient1 = ingredients[i];
                int ingredient2 = ingredients[j];
                totalSynergy += (synergies[ingredient1][ingredient2] + synergies[ingredient2][ingredient1]);
            }
        }
        return totalSynergy;
    }

    static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    static void reverse(int[] array, int idx) {
        int left = idx;
        int right = array.length - 1;
        while (left < right) {
            swap(array, left, right);
            ++left;
            --right;
        }
    }
}
