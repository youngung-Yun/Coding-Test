import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long winGrade = (long) (100.0 * y / x);
        long low = 1;
        long high = 100_000_000_000_000L;
        long result = -1L;
        while (low < high) {
            long mid = low + (high - low) / 2L;
            long winCount = y + mid;
            long playCount = x + mid;
            long newWinGrade = (long) (100.0 * winCount / playCount);
            if (newWinGrade > winGrade) {
                result = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(result);
    }
}