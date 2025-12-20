import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ordered = new int[n];

        for (int i = 0; i < n; i++) {
            int biggerCount = array[i];
            int currentCount = 0;
            int index = 0;
            // array[i] 만큼의 빈 자리를 만들어야 나보다 큰 수가 들어갈 수 있음
            while (currentCount < biggerCount) {
                if (ordered[index] == 0) {
                    ++currentCount;
                }
                ++index;
            }
            // 빈자리를 만날 때까지 뒤로 이동
            while (ordered[index] != 0) {
                ++index;
            }
            ordered[index] = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int e : ordered) {
            sb.append(e).append(' ');
        }
        System.out.println(sb.toString());
    }
}
