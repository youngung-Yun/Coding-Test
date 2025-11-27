import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int e = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);

        int year = 1;
        while (true) {
            int ne = (year % 15 == 0) ? 15 : year % 15;
            int ns = (year % 28 == 0) ? 28 : year % 28;
            int nm = (year % 19 == 0) ? 19 : year % 19;

            if (ne == e && ns == s && nm == m) {
                break;
            }
            ++year;
        }

        System.out.println(year);
    }
}