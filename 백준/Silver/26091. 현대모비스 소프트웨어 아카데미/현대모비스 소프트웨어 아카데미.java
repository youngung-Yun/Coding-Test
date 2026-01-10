import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int left = 0;
        int right = n - 1;
        int answer = 0;
        while (left < right) {
            if (array[left] + array[right] >= m) {
                ++answer;
                ++left;
                --right;
            } else {
                ++left;
            }
        }
        System.out.println(answer);
    }
}