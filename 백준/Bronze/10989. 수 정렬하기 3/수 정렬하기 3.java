import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] counting = new int[10_001];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            ++counting[number];
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            int curr = 1;
            while (count < n) {
                if (counting[curr] <= 0) {
                    ++curr;
                    continue;
                }
                --counting[curr];
                sb.append(curr).append('\n');
                ++count;
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
