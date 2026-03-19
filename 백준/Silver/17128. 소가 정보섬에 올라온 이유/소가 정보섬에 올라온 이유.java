import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int[] multiple = new int[n];
        multiple[0] = arr[0] * arr[1] * arr[2] * arr[3];
        int sum = multiple[0];
        for (int i = 1; i < n; i++) {
            multiple[i] = (multiple[i-1] / arr[i-1]) * arr[(i+3)%n];
            sum += multiple[i];
        }

        StringBuilder sb = new StringBuilder();
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < q; i++) {
            int number = Integer.parseInt(stk.nextToken()) - 1;
            for (int k = 3; k >= 0; k--) {
                int prev = (number - k + n) % n;
                sum -= (multiple[prev] * 2);
                multiple[prev] *= -1;
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}