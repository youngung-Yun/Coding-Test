import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] seq = new int[n];
        seq[0] = 1;
        for (int i = 1; i < n; i++) {
            int diff = i;
            if (i % 2 == 1) {
                seq[i] = seq[i-1] + diff;
            } else {
                seq[i] = seq[i-1] - diff;
            }
        }

        int min = Arrays.stream(seq).min().getAsInt();
        if (min <= 0) {
            for (int i = 0; i < n; i++) {
                seq[i] += (-min + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(seq[i]).append(' ');
        }
        System.out.println(sb);
    }

}