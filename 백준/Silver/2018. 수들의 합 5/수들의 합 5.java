import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 0;
        int result = 0;
        while (right <= n) {
            sum += right;
            ++right;

            while (sum > n && left < right) {
                sum -= left;
                ++left;
            }
            if (sum == n) {
                ++result;
            }
        }
        System.out.println(result);
    }
}