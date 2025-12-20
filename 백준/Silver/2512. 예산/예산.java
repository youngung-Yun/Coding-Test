import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(br.readLine());
        long[] requests = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long budget = Long.parseLong(br.readLine());

        /*
         * upper bound로 할당 불가능한 처음 예산 구한 후 -1하기
         */
        long low = 0L;
        long high = Arrays.stream(requests).max().getAsLong() + 1L;

        while (low < high) {
            long mid = low + (high - low) / 2;

            // 할당 불가능
            if (checkBudget(requests, mid, budget)) {
                high = mid;
            }
            else {
                low = mid + 1L;
            }
        }

        System.out.println(low - 1L);
    }

    private static boolean checkBudget(long[] array, long upper, long budget) {
        long total = 0L;
        for (long e: array) {
            total += Math.min(upper, e);
        }

        return total > budget;
    }
}