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

        int answer = n + 1;
        int count = 0;
        int left = 0;
        // 현재 부분 배열에서 라이언 인형이 K개 미만: 패스
        // K개 이상: K개 될 때 까지 left 줄인 후 길이 특정
        // 가장 짧은 부분 배열이어야 하므로 array[left]는 반드시 라이언 인형이어야 함
        for (int right = 0; right < n; right++) {
            if (array[right] == 1) {
                ++count;
            }
            if (count < k) {
                continue;
            }
            while (left < right && (count > k || array[left] != 1)) {
                if (array[left] == 1) {
                    --count;
                }
                ++left;
            }
            int length = right - left + 1;
            answer = Integer.min(answer, length);
        }
        if (answer == n + 1) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}