import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] wines = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        int left = 0;
        int right = n - 1;
        long total = 0;
        long prev = 0;
        int count = 0;
        boolean flag = false;
        while (count < k) {
            if (flag) {
                prev = wines[left];
                flag = false;
                ++left;
            } else {
                long diff = wines[right] - prev;
                total += diff;
                --right;
                flag = true;
            }
            ++count;
        }
        System.out.println(total);
    }
}