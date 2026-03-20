import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String number = bf.readLine();
        int n = number.length();

        int idx = 0;
        int curr = 1;
        while (idx < n) {
            for (char digit : String.valueOf(curr).toCharArray()) {
                if (idx >= n) {
                    break;
                }
                if (number.charAt(idx) == digit) {
                    ++idx;
                }
            }
            ++curr;
        }
        System.out.println(--curr);
    }
}