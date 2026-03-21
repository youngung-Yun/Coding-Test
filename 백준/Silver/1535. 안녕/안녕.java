import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] health = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            health[i] = Integer.parseInt(stk.nextToken());
        }

        int[] pleasure = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            pleasure[i] = Integer.parseInt(stk.nextToken());
        }

        for (int binary = 1; binary < (0b1 << n); binary++) {
            compute(health, pleasure, binary, n);
        }

        System.out.println(ans);
    }

    static void compute(int[] health, int[] pleasure, int binary, int n) {
        int currentHealth = 100;
        int currentPleasure = 0;
        for (int i = 0; i < n; i++) {
            if ((binary & (0b1 << i)) == 0) {
                continue;
            }
            currentHealth -= health[i];
            currentPleasure += pleasure[i];
        }
        if (currentHealth > 0) {
            ans = Integer.max(ans, currentPleasure);
        }
    }
}