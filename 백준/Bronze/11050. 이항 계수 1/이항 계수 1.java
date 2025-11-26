import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] factorials = new int[11];
        factorials[0] = 1;
        for (int i = 1; i <= 10; ++i) {
            factorials[i] = factorials[i - 1] * i;
        }

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        int answer = factorials[n] / (factorials[k] * factorials[n - k]);

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}