import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        // lower bound로 sqrt(n)보다 큰 첫 번째 수 출력
        long low = 0L;
        long high = (long) Math.sqrt(n) + 1L;
        while (low < high) {
            long mid = low + (high - low) / 2L;
            if (mid * mid >= n) {
                high = mid;
            } else {
                low = mid + 1L;
            }
        }
        System.out.println(low);
    }
}