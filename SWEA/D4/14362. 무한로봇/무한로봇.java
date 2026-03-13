import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    final static int[][] dirs = { {0, 1}, {-1, 0}, {0, -1}, {1, 0} } ;

    static int x;
    static int y;
    static int d;
    static int maxDistance = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            x = 0;
            y = 0;
            d = 0;
            maxDistance = 0;
            String command = bf.readLine();
            for (int i = 0; i < 4; i++) {
                simulate(command);
            }

            sb.append('#').append(tc).append(' ')
                    .append((x != 0 || y != 0) ? "oo" : maxDistance).append('\n');

        }
        System.out.println(sb);
    }

    private static void simulate(String command) {
        for (char ch : command.toCharArray()) {
            if (ch == 'S') {
                x += dirs[d][0];
                y += dirs[d][1];
            } else if (ch == 'L') {
                d = (d + 1) % 4;
            } else if (ch == 'R') {
                d = (d + 3) % 4;
            }
            int distance = getDistance();
            maxDistance = Integer.max(maxDistance, distance);
        }
    }

    private static int getDistance() {
        int dx = Math.abs(x);
        int dy = Math.abs(y);
        return dx * dx + dy * dy;
    }
}
