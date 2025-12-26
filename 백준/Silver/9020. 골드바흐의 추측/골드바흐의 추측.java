import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[10_001];
        for (int i = 2; i <= 100 ; i++) {
            if (!visited[i]) {
                for (int k = i + i; k <= 10_000; k += i) {
                    visited[k] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            for (int i = n / 2; i >= 2; i--) {
                if (!visited[i] && !visited[n - i]) {
                    sb.append(i).append(' ').append(n - i).append('\n');
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }

}

