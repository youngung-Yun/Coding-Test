import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int question = Integer.parseInt(br.readLine());
            int answer = binarySearch(array, question);
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static int binarySearch(int[] array, int x) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low >= array.length || array[low] != x) {
            return -1;
        }
        return low;
    }
}