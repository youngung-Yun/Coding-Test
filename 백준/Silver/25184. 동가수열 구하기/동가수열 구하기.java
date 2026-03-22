import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] seq = new int[n];
        int diff = n / 2;
        seq[0] = (n + 1) / 2;

        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                seq[i] = seq[i-1] + diff;
            } else {
                seq[i] = seq[i-2] - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int e : seq) {
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }

}