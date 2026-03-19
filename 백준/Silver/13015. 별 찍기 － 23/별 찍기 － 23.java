import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 2 * n - 1; r++) {
            if (r == 0 || r == 2 * n - 2) {
                paint(sb, n, '*');
                paint(sb, (n - 1) * 2 - 1, ' ');
                paint(sb, n, '*');
            } else if (r < n - 1) {
                paint(sb, r, ' ');

                sb.append('*');
                paint(sb, n - 2, ' ');
                sb.append('*');

                paint(sb, (n - r - 1) * 2 - 1, ' ');

                sb.append('*');
                paint(sb, n - 2, ' ');
                sb.append('*');
            } else if (r == n - 1) {
                paint(sb, n - 1, ' ');
                sb.append('*');
                paint(sb, n - 2, ' ');
                sb.append('*');
                paint(sb, n - 2, ' ');
                sb.append('*');
            } else {
                paint(sb, (n * 2) - r - 2, ' ');

                sb.append('*');
                paint(sb, n - 2, ' ');
                sb.append('*');

                paint(sb, ((r - n) * 2) + 1, ' ');

                sb.append('*');
                paint(sb, n - 2, ' ');
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }


    private static void paint(StringBuilder sb, int count, char ch) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}