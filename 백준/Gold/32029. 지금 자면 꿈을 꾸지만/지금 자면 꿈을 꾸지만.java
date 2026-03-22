import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int a;
    static int b;
    static int[] deadline;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(stk.nextToken());
        a = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());

        deadline = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            deadline[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(deadline);

        // i번째 과제 전에 잠
        for (int sleep = 0; sleep < n; sleep++) {
            // 잠을 몇시간 잘지
            for (int x = 0; x <= a - 1; x++) {
                simulate(sleep, x);
            }
        }
        System.out.println(ans);
    }

    static void simulate(int sleepIdx, int x) {
        int currentTime = 0;
        int duration = a;

        Queue<Integer> completeQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (i == sleepIdx) {
                currentTime += x * b;
                duration -= x;
            }
            currentTime += duration;
            completeQueue.offer(currentTime);
        }

        int count = 0;
        for (int d : deadline) {
            int completeTime = completeQueue.peek();
            if (completeTime <= d) {
                completeQueue.poll();
                ++count;
            }
        }

        ans = Integer.max(ans, count);
    }
}