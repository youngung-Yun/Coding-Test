import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] visited = new boolean[10_000_001];
        Arrays.fill(visited, true);
        visited[0] = false;
        visited[1] = false;
        for (int i = 2; i <= (int) Math.floor(Math.sqrt(10_000_000)); i++) {
            if (visited[i]) {
                for (int k = i + i; k <= 10_000_000; k += i) {
                    visited[k] = false;
                }
            }
        }
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            int low = n;
            while (!visited[low]) {
                --low;
            }
            int high = n;
            while (!visited[high]) {
                ++high;
            }
            sb.append(high - low).append('\n');
        }
        System.out.println(sb);
    }
}