import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] food = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = 0;
        for (int binary = 0; binary < (0b1 << n); binary++) {
            int pleasure = 0;
            int energy = 0;
            for (int seq = 0; seq < n; seq++) {
                if ((binary & (0b1 << seq)) != 0) {
                    pleasure += food[seq];
                    if (pleasure >= k) {
                        energy += pleasure - k;
                        pleasure = 0;
                    }
                }
            }
            ans = Integer.max(ans, energy);
        }
        System.out.println(ans);
    }
}
