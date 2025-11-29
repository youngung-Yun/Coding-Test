import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());

        int round = 1;
        while (true) {
            kim = getNextNumber(kim);
            lim = getNextNumber(lim);
            if (kim == lim) {
                break;
            }
            n = (n % 2 == 0) ? (n / 2) : ((n / 2) + 1);
            ++round;
        }

        System.out.println(round);
    }

    private static int getNextNumber(int n) {
        return (n + 1) / 2;

    }
}