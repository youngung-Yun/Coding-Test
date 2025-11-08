import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long s = Long.parseLong(br.readLine());

        long count = 0;
        long i = 0;
        long k = s;

        while (true) {
            if (k - i <= i) {
                break;
            }
            ++count;
            k -= i;
            ++i;
        }

        System.out.println(count);
    }

}