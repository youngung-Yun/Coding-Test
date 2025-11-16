import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        // true: 소수아님, false: 소수임
        boolean[] array = new boolean[m + 1];
        array[0] = true;
        array[1] = true;
        for (int i = 2; i <= Math.floor(Math.sqrt(m)); i++) {
            if (!array[i]) {
                for (int k = i * i; k <= m; k += i) {
                    array[k] = true;
                }
            }
        }

        for (int i = n; i <= m; i++) {
            if (!array[i]) {
                sb.append(i).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

}