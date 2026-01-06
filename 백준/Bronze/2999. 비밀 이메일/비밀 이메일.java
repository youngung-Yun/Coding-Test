import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String encrypted = br.readLine();
        int n = encrypted.length();
        int r = 0;
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && i <= (n / i)) {
                r = i;
                c = n / i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = i; j < n; j += r) {
                sb.append(encrypted.charAt(j));
            }
        }
        System.out.println(sb);
    }
}