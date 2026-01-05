import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        int bottom = n;
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] == bottom) {
                --bottom;
            }
        }
        System.out.println(bottom);
    }
}
