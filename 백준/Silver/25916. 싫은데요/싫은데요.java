import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] array = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long answer = 0;
        long total = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            total += array[right];
            while (total > m) {
                total -= array[left];
                ++left;
            }
            answer = Long.max(answer, total);
        }
        System.out.println(answer);
    }
}