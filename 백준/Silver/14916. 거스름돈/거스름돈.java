import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = -1;
        for (int i = n / 5; i >= 0; --i) {
            int rest = n - (i * 5);
            if (rest % 2 == 0) {
                count = i + (rest / 2);
                break;
            }
        }

        System.out.println(count);

        br.close();
    }
}