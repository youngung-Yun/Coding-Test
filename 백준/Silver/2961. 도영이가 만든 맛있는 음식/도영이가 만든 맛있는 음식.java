import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Food[] foods = new Food[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer sour = Integer.parseInt(st.nextToken());
            Integer bitter = Integer.parseInt(st.nextToken());
            foods[i] = new Food(sour, bitter);
        }

        int result = 1_000_000_000;
        for (int i = 1; i < 1 << n; i++) {
            int totalSour = 1;
            int totalBitter = 0;
            for (int b = 0; b < n; b++) {
                if ((i & (0b1 << b)) > 0) {
                    totalSour *= foods[b].sour;
                    totalBitter += foods[b].bitter;
                }
            }
            result = Integer.min(result, Math.abs(totalBitter - totalSour));
        }
        System.out.println(result);
    }

    private static class Food {
        public int sour;
        public int bitter;

        public Food(int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }
    }
}