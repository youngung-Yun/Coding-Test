import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int highLimit = 11;
        int lowLimit = 0;
        boolean isHonest = true;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            String answer = br.readLine();
            switch (answer) {
                case "too high":
                    if (n <= lowLimit + 1) {
                        isHonest = false;
                    }
                    highLimit = Integer.min(highLimit, n);
                    break;
                case "too low":
                    if (n >= highLimit - 1) {
                        isHonest = false;
                    }
                    lowLimit = Integer.max(lowLimit, n);
                    break;
                default:
                    if (n <= lowLimit || n >= highLimit) {
                        isHonest = false;
                    }
                    if (isHonest) {
                        sb.append("Stan may be honest");
                    } else {
                        sb.append("Stan is dishonest");
                    }
                    sb.append('\n');
                    highLimit = 11;
                    lowLimit = 0;
                    isHonest = true;
                    break;

            }
        }
        System.out.println(sb.toString());
    }
}

