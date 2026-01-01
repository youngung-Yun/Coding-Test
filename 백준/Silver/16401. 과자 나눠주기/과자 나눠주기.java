import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] snacks = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(st.nextToken());
            snacks[i] = length;
            max = Integer.max(max, length);
        }

        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int snack : snacks) {
                count += (snack / mid);
            }
            // mid가 더 길어져야 하거나 현재가 최적 -> left를 이동
            if (count >= m) {
                left = mid + 1;
            } else {
                // mid가 더 짧아야 함 -> right를 이동
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}