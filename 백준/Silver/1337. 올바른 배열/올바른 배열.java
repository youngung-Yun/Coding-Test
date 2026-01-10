import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        // 1. 현재 위치부터 5 이상 작은 값이 나올때까지 left 포인터를 이동
        // 2. 필요한 요소의 개수 = 5 - (right - left)개
        int result = 5;
        for (int right = 0; right < n; right++) {
            int current = array[right];
            int left = right - 1;
            while (left >= 0 && current - array[left] < 5) {
                --left;
            }
            int count = 5 - (right - left);
            result = Integer.min(result, count);
        }
        System.out.println(result);
    }
}