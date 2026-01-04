import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int min = 200_000;
        for (int i = 0; i < n; i++) {
            int sum = array[i] + array[array.length-1-i];
            min = Integer.min(min, sum);
        }
        System.out.println(min);
    }
}
