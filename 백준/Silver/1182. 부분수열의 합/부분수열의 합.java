import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        recursion(array, 0, 0, s, 0);

        System.out.println(result);
    }

    private static void recursion(int[] array, int index, int sum, int s, int count) {
        if (index >= array.length) {
            if (count > 0 && sum == s) {
                ++result;
            }
            return;
        }

        recursion(array, index + 1, sum + array[index], s, count + 1);
        recursion(array, index + 1, sum, s, count);
    }
}