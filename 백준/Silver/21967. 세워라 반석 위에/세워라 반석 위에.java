import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        int left = 0;
        int[] counts = new int[11];
        for (int right = 0; right < n; right++) {
            int rightValue = array[right];
            ++counts[rightValue];
            while (left < right && getMax(counts) - getMin(counts) > 2) {
                int leftValue = array[left];
                --counts[leftValue];
                ++left;
            }
            result = Integer.max(result, right - left + 1);
        }
        System.out.println(result);
    }

    private static int getMax(int[] array) {
        for (int i = 10; i >= 1; i--)
            if (array[i] > 0) {
                return i;
        }
        return 0;
    }

    private static int getMin(int[] array) {
        for (int i = 1; i <= 10; i++)
            if (array[i] > 0) {
                return i;
            }
        return 0;
    }
}