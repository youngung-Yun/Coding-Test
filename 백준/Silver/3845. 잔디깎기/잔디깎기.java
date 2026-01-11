import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            double w = Double.parseDouble(st.nextToken());
            if (nx == 0) {
                break;
            }
            double[] xi = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).sorted().toArray();
            double[] yi = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).sorted().toArray();
            boolean canMowAll = true;

            double endX = 0.0;
            for (double x : xi) {
                double halfWidth = w / 2.0;
                if (endX == 0.0) {
                    endX = w;
                }
                // 못 깎는 부분 생김
                else if (endX + halfWidth < x) {
                    canMowAll = false;
                    break;
                } else if (x + halfWidth <= endX) {
                    // 이미 다 깎은 부분
                    continue;
                } else {
                    endX = x + halfWidth;
                }
            }
            double endY = 0.0;
            for (double y : yi) {
                double halfHeight = w / 2.0;
                if (endY == 0.0) {
                    endY = w;
                }
                // 못 깎는 부분 생김
                else if (endY + halfHeight < y) {
                    canMowAll = false;
                    break;
                } else if (y + halfHeight <= endY) {
                    // 이미 다 깎은 부분
                    continue;
                } else {
                    endY = y + halfHeight;
                }
            }
            if (endX < 75.0 || endY < 100.0) {
                canMowAll = false;
            }
            sb.append(canMowAll ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }
}