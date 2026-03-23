import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[] lectures = new int[n];
        int low = 1;
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int time = Integer.parseInt(stk.nextToken());
            lectures[i] = time;
            low = Integer.max(low, time);
        }

        int high = 100_000 * 10_000 + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canAttachAll(lectures, mid, m)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }

    static boolean canAttachAll(int[] times, int limitTime, int limitCount) {
        int totalTime = 0;
        int count = 1;
        for (int t : times) {
            if (totalTime + t <= limitTime) {
                totalTime += t;
                continue;
            }
            ++count;
            totalTime = t;
        }
        return count <= limitCount;
    }
}