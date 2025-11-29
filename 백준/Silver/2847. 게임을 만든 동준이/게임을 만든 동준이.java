import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] levels = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = n - 2; i >= 0; --i) {
            if (levels[i] >= levels[i + 1]) {
                int down = levels[i] - (levels[i + 1] - 1);
                count += down;
                levels[i] -= down;
            }
        }

        System.out.println(count);
    }
}