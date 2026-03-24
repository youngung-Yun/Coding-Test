import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] seq;
    static int[] mins;
    static int[] maxes;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(bf.readLine());
        }

        int size = (int) Math.sqrt(n);
        int length = (int) Math.ceil((double) n / size);
        mins = new int[length];
        Arrays.fill(mins, 1_000_000_001);
        for (int s = 0; s < n; s++) {
            int bucket = s / size;
            mins[bucket] = Integer.min(mins[bucket], seq[s]);
        }

        maxes = new int[length];
        for (int s = 0; s < n; s++) {
            int bucket = s / size;
            maxes[bucket] = Integer.max(maxes[bucket], seq[s]);
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int left = Integer.parseInt(stk.nextToken()) - 1;
            int right = Integer.parseInt(stk.nextToken()) - 1;
            int[] result = query(size, n, left, right);
            sb.append(result[0]).append(' ').append(result[1]).append('\n');
        }
        System.out.println(sb);
    }

    static int[] query(int size, int n, int left, int right) {
        int min = 1_000_000_001;
        int max = 0;

        int leftBlockIdx = left / size;
        int rightBlockIdx = right / size;

        if (leftBlockIdx == rightBlockIdx) {
            for (int i = left; i <= right; i++) {
                min = Integer.min(min, seq[i]);
                max = Integer.max(max, seq[i]);
            }
            return new int[] {min, max};
        }

        for (int i = left; i < (leftBlockIdx + 1) * size; i++) {
            min = Integer.min(min, seq[i]);
            max = Integer.max(max, seq[i]);
        }
        for (int i = leftBlockIdx + 1; i < rightBlockIdx; i++) {
            min = Integer.min(min, mins[i]);
            max = Integer.max(max, maxes[i]);
        }
        for (int i = rightBlockIdx * size; i <= right; i++) {
            min = Integer.min(min, seq[i]);
            max = Integer.max(max, seq[i]);
        }
        return new int[] {min, max};
    }
}