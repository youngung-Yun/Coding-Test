import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            // {number : pos}
            Map<Integer, int[]> map = new HashMap<>();

            for (int r = 0; r < n; r++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    int number = Integer.parseInt(token.nextToken());
                    map.put(number, new int[] {r, c});
                }
            }

            boolean[] visited = new boolean[n*n+1];
            int maxCount = 0;
            int minNumber = n * n + 1;
            for (int i = 1; i <= n * n; i++) {
                if (visited[i]) {
                    continue;
                }

                int count = 1;
                int current = i;
                int next = i + 1;
                visited[i] = true;
                while (next <= n * n && isNearby(map.get(current), map.get(next))) {
                    count += 1;
                    current += 1;
                    next += 1;
                    visited[i] = true;
                }
                if (maxCount < count) {
                    maxCount = count;
                    minNumber = i;
                }
            }
            sb.append('#').append(testCase).append(' ').append(minNumber).append(' ').append(maxCount).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static boolean isNearby(int[] current, int[] target) {
        int dx = current[0] - target[0];
        int dy = current[1] - target[1];

        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1) ||
                (dx == -1 && dy == 0) || (dx == 0 && dy == -1);
    }
}