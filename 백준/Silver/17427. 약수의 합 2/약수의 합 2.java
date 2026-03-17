import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bf.readLine());
        long ans = 0;
        for (long d = 1L; d <= n; d++) {
            ans += (n / d) * d;
        }
        System.out.println(ans);
    }
}