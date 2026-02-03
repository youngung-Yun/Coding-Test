import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer token = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr);
        int value = 2_000_000_000;
        int[] solution = new int[2];
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mix = arr[left] + arr[right];
            // 특성값 비교
            if (Math.abs(mix) < value) {
                value = Math.abs(mix);
                solution = new int[] {arr[left], arr[right]};
            }

            // 0보다 작으면 left 증가
            if (mix < 0) {
                ++left;
            // 0보다 크거나 같으면 right 감소
            } else {
                --right;
            }
        }
        System.out.println(solution[0] + " " + solution[1]);
    }
}