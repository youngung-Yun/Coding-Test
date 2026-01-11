import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] array;
    static int[] tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tmp = new int[n];
        int k = Integer.parseInt(br.readLine());

        mergeSort(0, n, 1, k);

        StringBuilder sb = new StringBuilder();
        for (int e : array) {
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }

    static void mergeSort(int left, int right, int depth, int limit) {
        // 배열 길이가 1
        if (left + 1 == right) {
            return;
        }
        int mid = (left + right) / 2;

        mergeSort(left, mid, depth * 2, limit);
        mergeSort(mid, right, depth * 2, limit);

        if (depth >= limit) {
            merge(left, mid, right);
        }
    }

    static void merge(int left, int mid, int right) {
        int lIndex = left;
        int rIndex = mid;

        for (int i = left; i < right; i++) {
            // 왼쪽 배열이 끝까지 도달
            if (lIndex == mid) {
                tmp[i] = array[rIndex];
                ++rIndex;
            // 오른쪽 배열이 끝까지 도달
            } else if (rIndex == right) {
                tmp[i] = array[lIndex];
                ++lIndex;
            } else if (array[lIndex] <= array[rIndex]) {
                tmp[i] = array[lIndex];
                ++lIndex;
            } else {
                tmp[i] = array[rIndex];
                ++rIndex;
            }
        }
        for (int i = left; i < right; i++) {
            array[i] = tmp[i];
        }
    }
}