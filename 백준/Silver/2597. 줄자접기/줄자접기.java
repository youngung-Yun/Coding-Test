import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        double[][] dots = new double[3][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int k = 0; k < 2; k++) {
                dots[i][k] = Double.parseDouble(stk.nextToken());
            }
        }

        double length = n;
        for (int i = 0; i < 3; i++) {
            double[] dot = dots[i];
            double min = Double.min(dot[0], dot[1]);
            double max = Double.max(dot[0], dot[1]);
            if (min == max) {
                continue;
            }

            double center = (min + max) / 2.0;

            // 접었을 때 왼쪽이 더 긺
            double left = center;
            double right = length - center;
            if (left >= right) {
                for (int j = i + 1; j < 3; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (dots[j][k] > center) {
                            dots[j][k] = center - (dots[j][k] - center);
                        }
                    }
                }
                length = left;
            // 오른쪽이 더 긺
            } else {
                for (int j = i + 1; j < 3; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (dots[j][k] > center) {
                            dots[j][k] = length - dots[j][k];
                        } else {
                            dots[j][k] += (right - left);
                        }
                    }
                }
                length = right;
            }
        }
        System.out.printf("%.1f", length);
    }
}