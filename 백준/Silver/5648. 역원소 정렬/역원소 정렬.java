import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(sc.next());
            array[i] = Long.parseLong(sb.reverse().toString());
        }

        Arrays.sort(array);

        for (long number : array) {
            System.out.println(number);
        }
    }

}