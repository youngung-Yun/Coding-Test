import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] array = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long k = Long.parseLong(br.readLine());

        long answer = 0;
        long total = 0;
        int left = 0;
        // 1. array[right]를 더함
        // 2. 합이 k보다 작거나 같아질 때까지 left의 값을 빼고 left를 증가시킴
        // 3. [0, right] 부터 [left-1, right] 까지의 left개는 k보다 큼
        for (int right = 0; right < n; right++) {
            total += array[right];
            while (total > k) {
                total -= array[left];
                ++left;
            }
            answer += left;
        }
        System.out.println(answer);
    }
}