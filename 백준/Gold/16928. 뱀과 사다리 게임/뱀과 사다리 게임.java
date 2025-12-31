import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.put(start, end);
        }

        int[] board = new int[101];
        Arrays.fill(board, -1);
        board[1] = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(1);
        while (!queue.isEmpty()) {
            int current = queue.removeFirst();
            for (int i = 1; i <= 6; i++) {
                int next = current + i;
                if (next > 100) {
                    continue;
                }
                if (map.containsKey(next)) {
                    next = map.get(next);
                }

                if (board[next] == -1) {
                    board[next] = board[current] + 1;
                    queue.offerLast(next);
                }
            }
        }
        System.out.println(board[100]);
    }
}

