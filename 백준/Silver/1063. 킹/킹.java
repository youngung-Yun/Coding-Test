import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, int[]> directionsMap = new HashMap<>();
        directionsMap.put("R", new int[] {0, 1});
        directionsMap.put("L", new int[] {0, -1});
        directionsMap.put("B", new int[] {-1, 0});
        directionsMap.put("T", new int[] {1, 0});
        directionsMap.put("RT", new int[] {1, 1});
        directionsMap.put("LT", new int[] {1, -1});
        directionsMap.put("RB", new int[] {-1, 1});
        directionsMap.put("LB", new int[] {-1, -1});

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] king = getPosition(st.nextToken());
        int kingX = king[0];
        int kingY = king[1];
        int[] stone = getPosition(st.nextToken());
        int stoneX = stone[0];
        int stoneY = stone[1];
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String move = br.readLine();
            int[] direction = directionsMap.get(move);
            int dx = kingX + direction[0];
            int dy = kingY + direction[1];
            if (!isValidPosition(dx, dy)) {
                continue;
            }
            // 도착 위치에 돌 있는 경우
            if (stoneX == dx && stoneY == dy) {
                int ddx = stoneX + direction[0];
                int ddy = stoneY + direction[1];
                if (!isValidPosition(ddx, ddy)) {
                    continue;
                }
                kingX = dx;
                kingY = dy;
                stoneX = ddx;
                stoneY = ddy;
                // 없으면 킹만 이동
            } else {
                kingX = dx;
                kingY = dy;
            }
        }
        System.out.println(convert(kingX, kingY));
        System.out.println(convert(stoneX, stoneY));
    }

    private static int[] getPosition(String pos) {
        int x = Character.getNumericValue(pos.charAt(1));
        int y = pos.charAt(0) - 'A' + 1;
        return new int[] {x, y};
    }

    private static boolean isValidPosition(int x, int y) {
        if (x < 1 || y < 1 || x > 8 || y > 8) {
            return false;
        }
        return true;
    }

    private static String convert(int x, int y) {
        char alpha = (char) ('A' + y - 1);
        char number = (char) ('0' + x);
        return "" + alpha + number;
    }
}