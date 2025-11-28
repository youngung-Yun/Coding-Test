import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (i < 10) {
                ++count;
                continue;
            }
            String str = String.valueOf(i);
            boolean isHansu = true;
            int diff = Character.getNumericValue(str.charAt(1)) - Character.getNumericValue(str.charAt(0));
            for (int j = 1; j < str.length(); j++) {
                if (diff != Character.getNumericValue(str.charAt(j)) - Character.getNumericValue(str.charAt(j - 1))) {
                    isHansu = false;
                    break;
                }
            }
            if (isHansu) {
                ++count;
            }
        }

        System.out.println(count);
        br.close();
    }

}