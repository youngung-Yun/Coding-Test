import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (n == 1) {
            System.out.println("권병장님, 중대장님이 찾으십니다");
            return;
        }
        int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            if (end >= pos[i]) {
                end = Integer.max(end, pos[i] + range[i]);
            }
        }
        if (end >= pos[n-1]) {
            System.out.println("권병장님, 중대장님이 찾으십니다");
        } else {
            System.out.println("엄마 나 전역 늦어질 것 같아");
        }
    }
}