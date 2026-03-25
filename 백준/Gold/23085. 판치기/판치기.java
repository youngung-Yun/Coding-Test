import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        String coins = bf.readLine();
        int initFront = 0;
        int initBack = 0;
        for (char coin : coins.toCharArray()) {
            if (coin == 'H') {
                ++initFront;
            } else if (coin == 'T') {
                ++initBack;
            }
        }

        int[][] count = new int[n+1][n+1];
        for (int f = 0; f <= n; f++) {
            for (int b = 0; b <= n; b++) {
                count[f][b] = -1;
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {initFront, initBack});
        count[initFront][initBack] = 0;
        while (!queue.isEmpty() && count[0][n] == -1) {
            int[] state = queue.poll();
            int front = state[0];
            int back = state[1];
            // front를 f개, back을 b개 뒤집음
            for (int f = 0; f <= k; f++) {
                int b = k - f;
                if (front < f || back < b) {
                    continue;
                }
                int nextFront = front - f + b;
                int nextBack = back - b + f;
                if (count[nextFront][nextBack] != -1) {
                    continue;
                }
                count[nextFront][nextBack] = count[front][back] + 1;
                queue.offer(new int[] {nextFront, nextBack});
            }
        }
        System.out.println(count[0][n]);
    }
}