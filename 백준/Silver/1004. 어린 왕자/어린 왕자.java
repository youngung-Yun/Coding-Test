import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int destX = Integer.parseInt(st.nextToken());
            int destY = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());
            List<Planet> planets = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                planets.add(new Planet(x, y, r));
            }
            int count = 0;
            for (Planet p : planets) {
                if (isInPlanet(p, startX, startY) != isInPlanet(p, destX, destY)) {
                    ++count;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    private static class Planet {
        public int x;
        public int y;
        public int radius;

        public Planet(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }
    }

    private static boolean isInPlanet(Planet planet, int x, int y) {
        int dx = Math.abs(planet.x - x);
        int dy = Math.abs(planet.y - y);
        int distancePow = dx * dx + dy * dy;
        // 행성계의 중심과의 거리가 반지름보다 긺
        if (distancePow >= planet.radius * planet.radius) {
            return false;
        }
        return true;
    }

}