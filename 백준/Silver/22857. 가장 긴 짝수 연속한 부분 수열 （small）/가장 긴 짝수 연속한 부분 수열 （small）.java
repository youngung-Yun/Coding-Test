import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        int oddCount = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (array[right] % 2 == 1) {
                ++oddCount;
                continue;
            }
            // oddCount가 초과되었을 땐 k까지 줄이기 위해 left 이동해야함
            // oddCount가 k여도 array[left]가 짝수가 될 때 까지 이동
            if (left < right && (oddCount > k || array[left] % 2 == 1)) {
                if (array[left] % 2 == 1) {
                    --oddCount;
                }
                ++left;
            }
            while (left < right && array[left] % 2 == 1) {
                --oddCount;
                ++left;
            }

            // 부분 수열의 요소 개수는 right - left + 1개
            // 여기에 현재 홀수 개수인 oddCount를 뺸 것이 짝수의 개수
            int length = (right - left + 1) - oddCount;
            answer = Integer.max(answer, length);
        }
        System.out.println(answer);
    }
}