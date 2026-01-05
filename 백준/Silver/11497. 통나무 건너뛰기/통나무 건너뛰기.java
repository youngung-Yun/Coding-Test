import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            int[] logs = new int[n];
            int order = 0;
            int index = 0;
            while (order < n) {
                logs[index] = array[order];
                order += 2;
                ++index;
            }
            order = n % 2 == 0 ? n - 1 : n - 2;
            while (order > 0) {
                logs[index] = array[order];
                order -= 2;
                ++index;
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                int curr = logs[i];
                int left = logs[(i - 1 + n) % n];
                int right = logs[(i + 1 ) % n];
                int difficulty = Math.max(Math.abs(curr - left), Math.abs(curr - right));
                result = Math.max(result, difficulty);
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb.toString());
    }
}
