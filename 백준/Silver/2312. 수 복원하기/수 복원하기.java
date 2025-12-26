import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] counts = new int[100_001];
            int current = 2;
            while (n > 1) {
                if (n % current == 0) {
                    ++counts[current];
                    n /= current;
                } else {
                    ++current;
                }
            }
            for (int i = 2; i <= 100_000; i++) {
                if (counts[i] != 0) {
                    sb.append(i).append(' ').append(counts[i]).append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }
}

