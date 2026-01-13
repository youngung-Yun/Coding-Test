import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long[] currentLevels = new long[n];
        for (int i = 0; i < n; i++) {
            currentLevels[i] = Long.parseLong(br.readLine());
        }

        long low = 1L;
        long high = 2_000_000_001;
        // mid = 목표 레벨
        // needLevel = 모든 캐릭터를 mid까지 올리는데 필요한 레벨
        // 조건: needLevel > k인 최솟값에 1 빼기
        // 방식: lower bound
        while (low <= high) {
            long mid = low + (high - low) / 2L;
            long needLevel = computeNeedLevel(currentLevels, mid);
            if (needLevel > k) {
                high = mid - 1L;
            } else {
                low = mid + 1L;
            }
        }
        System.out.println(low - 1L);
    }

    static long computeNeedLevel(long[] array, long threshold) {
        long count = 0;
        for (long e : array) {
            if (e < threshold) {
                count += threshold - e;
            }
        }
        return count;
    }
}