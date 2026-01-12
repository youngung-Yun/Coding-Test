import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] array = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < m; t++) {
            String[] input = br.readLine().split(" ");
            int searchResult;
            // lower bound
            if (input[0].equals("1")) {
                long k = Long.parseLong(input[1]);
                searchResult = n - binarySearchAsLowerBound(array, k, n);
            } else if (input[0].equals("2")) {
                // upper bound
                long k = Long.parseLong(input[1]);
                searchResult = n - binarySearchAsUpperBound(array, k, n);

            } else {
                // i lower bound & (j upper bound - 1)
                long i = Long.parseLong(input[1]);
                long j = Long.parseLong(input[2]);
                searchResult = binarySearchAsUpperBound(array, j, n) - binarySearchAsLowerBound(array, i, n);
            }
            sb.append(searchResult).append('\n');
        }
        System.out.println(sb);
    }

    static int binarySearchAsLowerBound(long[] array, long n, int length) {
        int low = 0;
        int high = length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int binarySearchAsUpperBound(long[] array, long n, int length) {
        int low = 0;
        int high = length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}