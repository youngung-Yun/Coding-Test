import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long[] greenOnions = new long[s];
        long high = 0L;
        for (int i = 0; i < s; i++) {
            long greenOnion = Integer.parseInt(br.readLine());
            greenOnions[i] = greenOnion;
            high = Long.max(high, greenOnion);
        }

        long low = 1L;
        long result = 0L;
        // 조건: 만들 수 있는 파닭의 개수가 C개 이상임 [T, T, T, F...] ->
        // 방식: Upper Bound
        while (low <= high) {
            long mid = low + (high - low) / 2L;
            long chickenCount = 0;
            long rest = 0L;
            for (long greenOnion : greenOnions) {
                chickenCount += greenOnion / mid;
                rest += greenOnion % mid;
            }
            if (chickenCount >= c) {
                result = mid;
                low = mid + 1L;
            } else {
                high = mid - 1L;
            }
        }
        long answer = 0L;
        int count = 0;
        for (long greenOnion : greenOnions) {
            long rest = greenOnion;
            while (count < c && rest >= result) {
                ++count;
                rest -= result;
            }
            answer += rest;
        }
        System.out.println(answer);
    }
}