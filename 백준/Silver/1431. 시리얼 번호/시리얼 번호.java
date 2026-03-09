import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        String[] serials = new String[n];
        for (int i = 0; i < n; i++) {
            serials[i] = bf.readLine();
        }

        Arrays.sort(serials, (String s1, String s2) -> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }
            int sum1 = getSum(s1);
            int sum2 = getSum(s2);
            if (sum1 != sum2) {
                return Integer.compare(sum1, sum2);
            }

            return s1.compareTo(s2);
        });

        for (String serial : serials) {
            System.out.println(serial);
        }
    }

    private static int getSum(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum += (ch - '0');
            }
        }
        return sum;
    }
}