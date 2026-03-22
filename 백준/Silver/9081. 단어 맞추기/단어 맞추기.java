import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            String word = bf.readLine();
            char[] charArray = nextPermutation(word.toCharArray(), word.length());
            for (char ch : charArray) {
                sb.append(ch);
            }
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static char[] nextPermutation(char[] array, int n) {
        int idx = n - 2;
        while (idx >= 0 && array[idx] >= array[idx+1]) {
            --idx;
        }

        if (idx < 0) {
            return array;
        }

        int changeIdx = n - 1;
        while (array[idx] >= array[changeIdx]) {
            --changeIdx;
        }

        swap(array, idx, changeIdx);

        int left = idx + 1;
        int right = n - 1;
        while (left < right) {
            swap(array, left, right);
            ++left;
            --right;
        }

        return array;
    }

    static void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}