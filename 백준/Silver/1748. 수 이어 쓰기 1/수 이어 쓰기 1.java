import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        int count = 0;
        int digit = 1;
        int length = 1;

        while (true) {
            if (n >= (digit * 10)) {
                count += 9 * digit * length;
                digit *= 10;
                ++length;
            } else {
                count += (n - digit + 1) * length;
                break;
            }
        }

        System.out.println(count);
    }
}