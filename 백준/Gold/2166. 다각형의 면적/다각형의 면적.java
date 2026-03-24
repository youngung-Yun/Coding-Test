import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        double[][] vectors = new double[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            double x = Double.parseDouble(stk.nextToken());
            double y = Double.parseDouble(stk.nextToken());
            vectors[i] = new double[] {x, y};
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans + (vectors[i][0] * vectors[(i+1)%n][1]) - (vectors[(i+1)%n][0] * vectors[i][1]);
        }

        ans = Math.abs(ans) / 2.0;

        System.out.printf("%.1f", ans);
    }
}