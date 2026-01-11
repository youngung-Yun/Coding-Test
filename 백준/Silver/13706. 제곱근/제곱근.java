import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        // lower bound로 sqrt(n)보다 큰 첫 번째 수 출력
        BigInteger low = new BigInteger("0");
        BigInteger high = n.sqrt();
        while (low.compareTo(high) < 0) {
            BigInteger mid = low.add(high).divide(new BigInteger("2"));
            if (mid.pow(2).compareTo(n) >= 0) {
                high = mid;
            } else {
                low = mid.add(new BigInteger("1"));
            }
        }
        System.out.println(low.toString());
    }
}