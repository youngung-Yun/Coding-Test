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
        int[] dots = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(dots);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int left = findSmallestDot(dots, start);
            int right = findLargestDot(dots, end);
            sb.append(right - left).append('\n');
        }
        System.out.println(sb);
    }

    static int findSmallestDot(int[] dots, int start) {
        // start보다 크거나 같은 가장 작은 점의 인덱스 구함
        int low = 0;
        int high = dots.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (start <= dots[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int findLargestDot(int[] dots, int end) {
        // end보다 작거나 같은 가장 큰 점의 인덱스 구함
        int low = 0;
        int high = dots.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (dots[mid] <= end) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}