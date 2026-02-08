import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        while (nextPermutation()) {

        }

        System.out.println(sb);
    }

    static boolean nextPermutation() {
        printArray();

        int idx = n - 2;
        // 1. 뒤에서부터 오름차순이 깨지는 지점 찾기
        while (idx >= 0 && arr[idx] > arr[idx + 1]) {
            --idx;
        }
        // 모든 순열 찾음
        if (idx < 0) {
            return false;
        }

        // 2. idx의 뒤에서 arr[idx]보다 크면서 가장 작은 값 찾기
        int minIdx = 0;
        for (int i = n - 1; i > idx; i--) {
            if (arr[idx] < arr[i]) {
                minIdx = i;
                break;
            }
        }

        // 3. swap
        swap(idx, minIdx);

        // 4. 뒷부분 뒤집기
        reverse(idx + 1);

        return true;
    }

    static void printArray() {
        for (int e : arr) {
            sb.append(e).append(' ');
        }
        sb.append('\n');
    }

    static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void reverse(int idx) {
        int length = n - idx;
        for (int i = 0; i < length / 2; i++) {
            swap(idx + i, n - 1 - i);
        }
    }
}