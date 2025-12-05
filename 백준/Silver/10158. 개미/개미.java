import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());

        long t = Long.parseLong(br.readLine());

        long dw = t % (2L * w);
        long dh = t % (2L * h);

        int dx = 1;
        for (long i = 0; i < dw; i++) {
            if (p == 0 || p == w) {
                dx = -dx;
            }
            p += dx;
        }
        int dy = 1;
        for (long i = 0; i < dh; i++) {
            if (q == 0 || q == h) {
                dy = -dy;
            }
            q += dy;
        }
        System.out.println(p + " " + q);
    }
}