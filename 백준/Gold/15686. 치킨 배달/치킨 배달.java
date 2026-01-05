import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int result = 50 * 50 * 23 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Position> houses = new ArrayList<>();
        List<Position> chickens = new ArrayList<>();
        for (int row = 0; row < n; ++row) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; ++col) {
                int e = Integer.parseInt(st.nextToken());
                if (e == 1) {
                    houses.add(new Position(row, col));
                } else if (e == 2) {
                    chickens.add(new Position(row, col));
                }
            }
        }
        dfs(houses, chickens, 0, m, new Position[m], 0);
        System.out.println(result);
    }

    private static void dfs(List<Position> houses, List<Position> chickens, int depth, int limit, Position[] remainChickens, int current) {
        if (depth == limit) {
            computeChickenDistance(houses, remainChickens);
            return;
        }

        for (int i = current; i < chickens.size(); i++) {
            remainChickens[depth] = chickens.get(i);
            dfs(houses, chickens, depth + 1, limit, remainChickens, i + 1);
        }
    }

    private static void computeChickenDistance(List<Position> houses, Position[] remainChickens) {
        int sum = 0;
        for (Position house : houses) {
            int minDistance = 50 * 50;
            for (Position chicken : remainChickens) {
               int currDistance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
               minDistance = Integer.min(minDistance, currDistance);
            }
            sum += minDistance;
        }
        result = Integer.min(result, sum);
    }

    private static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
