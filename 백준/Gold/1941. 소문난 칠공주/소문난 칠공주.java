import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    static int ans = 0;
    static char[][] classroom = new char[5][5];

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 5; r++) {
            String row = bf.readLine();
            for (int c = 0; c < 5; c++) {
                classroom[r][c] = row.charAt(c);
            }
        }

        for (int bit = 1; bit < (0b1 << 25); bit++) {
            if (Integer.bitCount(bit) != 7) {
                continue;
            }

            List<Integer> list = new ArrayList<>();
            for (int digit = 0; digit < 25; digit++) {
                if ((bit & (0b1 << digit)) != 0) {
                    list.add(digit);
                }
            }

            // 이다솜파가 4명 이상인지 확인
            int sCount = 0;
            for (int e : list) {
                int r = e / 5;
                int c = e % 5;
                if (classroom[r][c] == 'S') {
                    ++sCount;
                }
            }
            if (sCount < 4) {
                continue;
            }

            if (isConnectedAll(list)) {
                ++ans;
            }
        }
        System.out.println(ans);
    }

    private static boolean isConnectedAll(List<Integer> list) {
        int count = 0;
        boolean[] visited = new boolean[25];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(list.get(0));
        visited[list.get(0)] = true;

        while (!queue.isEmpty()) {
            ++count;
            int now = queue.poll();
            int r = now / 5;
            int c = now % 5;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
                    continue;
                }
                int next = nr * 5 + nc;
                if (!visited[next] && list.indexOf(next) != -1) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return count == 7;
    }
}
