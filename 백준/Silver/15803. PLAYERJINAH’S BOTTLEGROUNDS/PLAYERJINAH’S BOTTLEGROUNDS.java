import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] x = new double[3];
        double[] y = new double[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Double.parseDouble(st.nextToken());
            y[i] = Double.parseDouble(st.nextToken());
        }

        if (((x[1] - x[0]) / (y[1] - y[0])) == ((x[2] - x[1]) / (y[2] - y[1]))) {
            System.out.println("WHERE IS MY CHICKEN?");
        } else {
            System.out.println("WINNER WINNER CHICKEN DINNER!");
        }
    }
    private static int computeGCD(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        if (min == 0) {
            return max;
        }
        return computeGCD(b, a % b);
    }
}
