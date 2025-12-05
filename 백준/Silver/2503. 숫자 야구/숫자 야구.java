import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 100; i < 1000; i++) {
            if (String.valueOf(i).contains("0")) {
                continue;
            }
            set.add(i);
        }
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());

            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            Set<Integer> tmpSet = new HashSet<>();
            for (int num = 100; num < 1000; num++) {
                if (isCan(number, num, strike, ball)) {
                    tmpSet.add(num);
                }
            }
            set.retainAll(tmpSet);
        }
        System.out.println(set.size());
    }

    private static boolean isCan(int number, int target, int strike, int ball) {
        String n = String.valueOf(number);
        String str = String.valueOf(target);
        // 중복 있으면 불가능
        if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2)) {
            return false;
        }
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            // strike
            char digit = str.charAt(i);
            if (digit == n.charAt(i)) {
                ++strikeCount;
            } else if (n.indexOf(digit) != -1) {
                // ball
                ++ballCount;
            }

        }
        return strike == strikeCount && ball == ballCount;
    }
}