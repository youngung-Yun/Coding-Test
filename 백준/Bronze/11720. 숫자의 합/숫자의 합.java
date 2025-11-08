import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String number = br.readLine();
        int sum = 0;

        for (int i = 0; i < N; ++i) {
            sum += Character.getNumericValue(number.charAt(i));
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}