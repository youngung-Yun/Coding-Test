import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String number = reader.readLine();

        int[] counting = new int[9];

        for (char ch : number.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            if (digit == 9) {
                ++counting[6];
            } else {
                ++counting[digit];
            }
        }
        counting[6] = (int) Math.ceil(counting[6] / 2.0);

        System.out.println(Arrays.stream(counting).max().getAsInt());
    }
}