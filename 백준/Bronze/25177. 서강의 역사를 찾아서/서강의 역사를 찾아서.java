import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] present = new int[1_000];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            present[i] = Integer.parseInt(st.nextToken());
        }
        int[] past = new int[1_000];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            past[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < 1_000; i++) {
            max = Integer.max(max, past[i] - present[i]);
        }
        System.out.println(max);
    }
}