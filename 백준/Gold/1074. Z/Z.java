import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int length = (int) Math.pow(2, n);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int result = recursion(0, 0, length, 0);
        System.out.println(result);
    }

    private static int recursion(int dx, int dy, int length, int sequence) {
        if (length == 1) {
            return sequence;
        }

        int half = length / 2;
        int halfPow = half * half;

        if (r < dx + half && c < dy + half) {
            return recursion(dx, dy, half, sequence);
        } else if (r < dx + half && c >= dy + half) {
            return recursion(dx, dy + half, half, sequence + halfPow);
        } else if (r >= dx + half && c < dy + half) {
            return recursion(dx + half, dy, half, sequence + halfPow * 2);
        } else {
            return recursion(dx + half, dy + half, half, sequence + halfPow * 3);
        }
    }
}