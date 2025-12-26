import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        while (true) {
            if (isPalindrome(n) && isPrimeNumber(n)) {
                System.out.println(n);
                break;
            }
            ++n;
        }

    }

    private static boolean isPalindrome(long n) {
        String str = String.valueOf(n);
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrimeNumber(long n) {
        if (n == 1L) {
            return false;
        }

        for (long i = 2; i <= (long) Math.ceil(Math.sqrt(n)); i++) {
            if (n % i == 0 && i != n) {
                return false;
            }
        }
        return true;
    }
}

