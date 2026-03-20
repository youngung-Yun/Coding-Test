import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int daldidalgo = 8;
    final static int daldidan = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());

        int total = daldidalgo;

        while (n > 1) {
            n /= 2;
            ++total;
        }

        total += daldidan;

        System.out.println(total);
    }

}