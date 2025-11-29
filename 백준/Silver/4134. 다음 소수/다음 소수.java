import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());
            while (!isPrimeNumber(n)) {
                ++n;
            }
            sb.append(n).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isPrimeNumber(long number) {
        if (number < 2L) {
            return false;
        }
        for (long i = 2L; i <= Math.floor(Math.sqrt(number)); i++) {
            if (number % i == 0L) {
                return false;
            }
        }
        return true;
    }
}