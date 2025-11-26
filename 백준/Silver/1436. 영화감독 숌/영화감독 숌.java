import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int number = 665;
        int i = 0;
        while (i < n) {
            ++number;
            String str = String.valueOf(number);
            if (str.contains("666"))
            {
                ++i;
            }
        }
        bw.write(String.valueOf(number));
        bw.flush();
    }
}