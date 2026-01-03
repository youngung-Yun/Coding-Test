import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int smallest = 1;
        int pow = 0;
        while (smallest < k) {
            smallest *= 2;
            ++pow;
        }
        int i = 0;
        while (((0b1 << i) & k) == 0) {
            ++i;
        }
        System.out.println(smallest + " " + (pow - i));
    }
}
