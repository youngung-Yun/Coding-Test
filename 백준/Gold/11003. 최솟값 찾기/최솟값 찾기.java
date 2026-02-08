import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());
        int[] arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            // 큐의 값이 현재 값보다 크면 이후로 절대 최솟값이 될 수 없으므로 큐에서 제거
            while (!deque.isEmpty() && arr[deque.peekLast()] > current) {
                deque.removeLast();
            }
            deque.offerLast(i);
            // 윈도우 범위 벗어난 값 제거
            if (deque.peekFirst() + l <= i) {
                deque.removeFirst();
            }
            sb.append(arr[deque.peekFirst()]).append(' ');
        }
        System.out.println(sb);
    }
}