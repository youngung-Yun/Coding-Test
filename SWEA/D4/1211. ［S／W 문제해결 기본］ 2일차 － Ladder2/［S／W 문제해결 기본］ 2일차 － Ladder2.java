import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    final static int WIDTH = 100;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(bf.readLine());
            List<Integer> startpoints = new ArrayList<>();
            int[][] ladder = new int[WIDTH][WIDTH];
            for (int r = 0; r < WIDTH; r++) {
                StringTokenizer stk = new StringTokenizer(bf.readLine());
                for (int c = 0; c < WIDTH; c++) {
                    ladder[r][c] = Integer.parseInt(stk.nextToken());
                    if (r == 0 && ladder[r][c] == 1) {
                        startpoints.add(c);
                    }
                }
            }

            int shortest = WIDTH * WIDTH;
            int ans = 0;
            for (int start : startpoints) {
                int distance = 0;
                int col = start;
                for (int row = 1; row < WIDTH; row++) {
                    int left = col - 1;
                    int right = col + 1;
                    if (left >= 0 && ladder[row][left] == 1) {
                        while (left >= 0 && ladder[row][left] == 1) {
                            ++distance;
                            col = left;
                            left = col - 1;
                        }
                    } else if (right < WIDTH && ladder[row][right] == 1) {
                        while (right < WIDTH && ladder[row][right] == 1) {
                            ++distance;
                            col = right;
                            right = col + 1;
                        }
                    }
                }
                if (shortest >= distance) {
                    shortest = distance;
                    ans = start;
                }
            }

            sb.append('#').append(tc).append(' ')
                    .append(ans).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
