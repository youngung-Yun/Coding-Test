import java.io.*;
import java.util.StringTokenizer;

public class Main {
private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        recursion(a, b, 1);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void recursion(long number, long target, int depth) {
        if (number > target) {
            return;
        }

        if (number == target) {
            min = Math.min(min, depth);
            return;
        }

        recursion(number * 2L, target, depth + 1);
        recursion(number * 10L + 1, target, depth + 1);
    }
}