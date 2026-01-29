import java.io.*;
import java.math.BigInteger;

public class Main {

    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        if (n == 1) {
            writer.write(String.valueOf(1));
            writer.write('\n');
        } else {
            writer.write(new BigInteger("2").pow(n).subtract(new BigInteger("1")).toString());
            writer.write('\n');
        }
        writer.flush();

        if (n <= 20) {
            recursion(n, 1, 3, 2);
            writer.flush();
        }
    }

    private static void recursion(int count, int from, int to, int through) throws IOException {
        if (count == 1) {
            writer.write(String.valueOf(from));
            writer.write(' ');
            writer.write(String.valueOf(to));
            writer.write('\n');
            return;
        }
        recursion(count - 1, from, through, to);
        recursion(1, from, to ,through);
        recursion(count - 1, through, to, from);
    }
}