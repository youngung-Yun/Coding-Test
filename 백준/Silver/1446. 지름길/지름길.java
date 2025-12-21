import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Shortcut[] array = new Shortcut[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            Shortcut shortcut = new Shortcut(start, end, distance);
            array[i] = shortcut;
        }
        Arrays.sort(array);
        int index = 0;
        int[] dp = new int[d + 1];
        for (int i = 1; i <= d; i++) {
            dp[i] = dp[i - 1] + 1;
            // 현재 지점이 도착점인 지름길이 있으면
            // 지름길을 이용하는 경우 중 가장 빠른 경우 선택
            while (index < n && array[index].end == i) {
                Shortcut shortcut = array[index];
                dp[i] = Math.min(dp[i], dp[shortcut.start] + shortcut.distance);
                ++index;
            }
        }

        System.out.println(dp[d]);
    }


    private static class Shortcut implements Comparable<Shortcut> {
        public int start;
        public int end;
        public int distance;

        public Shortcut(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Shortcut other) {
            return Integer.compare(this.end, other.end);
        }
    }
}
