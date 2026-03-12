import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(bf.readLine());
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            double[] coord = new double[n];
            double[] weight = new double[n];
            for (int i = 0; i < n; i++) {
                coord[i] = Double.parseDouble(stk.nextToken());
            }
            for (int i = 0; i < n; i++) {
                weight[i] = Double.parseDouble(stk.nextToken());
            }

            double[][] object = new double[n][2];
            for (int i = 0; i < n; i++) {
                object[i] = new double[] {coord[i], weight[i]};
            }

            Arrays.sort(object, (o1, o2) -> Double.compare(o1[0], o2[0]));

            sb.append('#').append(tc).append(' ');
            for (int i = 0; i < n - 1; i++) {
                double balancedPoint = binarySearch(object, object[i][0], object[i+1][0]);
                sb.append(String.format("%.10f", balancedPoint)).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static double binarySearch(double[][] object, double low, double high) {
        double mid = 0;
        for (int i = 0; i < 50_000; i++) {
            mid = low + (high - low) / 2.0;

            double left = 0.0;
            double right = 0.0;
            for (double[] o : object) {
                if (mid > o[0]) {
                    left += getPower(Math.abs(o[0] - mid), o[1]);
                } else {
                    right += getPower(Math.abs(mid - o[0]), o[1]);
                }
            }
            if (left < right) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return mid;
    }

    private static double getPower(double distance, double weight) {
        return weight / (distance * distance);
    }
}
