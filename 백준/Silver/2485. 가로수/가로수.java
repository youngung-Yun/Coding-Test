import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 모든 간격의 최대공약수(GCD) 구함
        // 간격마다 심어야 하는 가로수 수 = (간격 / GCD) - 1 그루
        int n = Integer.parseInt(br.readLine());
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }
        
        int[] distances = new int[n - 1];
        for (int i = 1; i < n; i++) {
            distances[i - 1] = trees[i] - trees[i - 1];
        }
        
        int gcd = distances[0];
        for (int distance : distances) {
            gcd = getGCD(gcd, distance);
        }

        int total = 0;
        for (int distance : distances) {
            total += (distance / gcd) - 1;
        }

        System.out.println(total);
    }

    private static int getGCD(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (min == 0) {
            return max;
        }
        return getGCD(min, max % min);
    }
}