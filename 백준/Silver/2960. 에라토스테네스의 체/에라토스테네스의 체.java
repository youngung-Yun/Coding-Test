import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        int count = 0;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            if (count == k) {
                break;
            }
            if (visited[i]) {
                continue;
            }
            for (int j = i; j <= n; j += i) {
                if (visited[j]) {
                    continue;
                }
                ++count;
                if (count == k) {
                    result = j;
                    break;
                }
                visited[j] = true;
            }
        }
        System.out.println(result);
    }
}

