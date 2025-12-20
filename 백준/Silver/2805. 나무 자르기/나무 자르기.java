import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        long m = Long.parseLong(input[1]);

        long[] trees = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        // true, true, true, ... true, false, false, false...
        // true중 가장 큰 값 = upper bound로 가장 처음 false 구한 후 -1하기
        // 만들 수 있으면 정답 아님.
        long min = 0;
        long max = 1_000_000_001;
        while (min < max) {
            long mid = (min + max) / 2;

            // 만들 수 있음
            if (checkTree(trees, mid, m)) {
                min = mid + 1;
            }
            else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }

    private static boolean checkTree(long[] array, long x, long n) {
        long total = 0;
        for (long e: array) {
            total += e > x ? e - x : 0;
        }

        return total >= n;
    }
}