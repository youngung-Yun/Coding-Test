import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int left = 1;
        int right = m;
        int total = 0;
        for (int i = 0; i < j; i++) {
            int apple = Integer.parseInt(br.readLine());
            if (apple >= left && apple <= right) {
                continue;
            } else if (apple < left) {
                int distance = left - apple;
                total += distance;
                left = apple;
                right -= distance;
            } else {
                int distance = apple - right;
                total += distance;
                right = apple;
                left += distance;
            }
        }
        System.out.println(total);
    }
}
