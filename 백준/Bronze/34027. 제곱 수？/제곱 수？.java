import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            double n = Double.parseDouble(br.readLine());
            double root = Math.sqrt(n);
            if (root % 1.0 == 0.0) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}