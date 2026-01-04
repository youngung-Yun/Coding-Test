import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tips = new int[n];
        for (int i = 0; i < n; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tips);
        long total = 0;
        for (int i = 1; i <= n; i++) {
            total += Integer.max(tips[n-i] - (i - 1), 0);
        }
        System.out.println(total);
    }
}
