import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            String binary = bf.readLine();
            String ternary = bf.readLine();

            int ans = 0;
            for (int i = 0; i < binary.length(); i++) {
                String changedBinary = makeNewBinary(binary, i);
                for (int j = 0; j < ternary.length(); j++) {
                    for (int digit = 0; digit < 3; digit++) {
                        if ((ternary.charAt(j) - '0') == digit) {
                            continue;
                        }
                        String changedTernary = makeNewTernary(ternary, j, digit);
                        if (Integer.parseInt(changedBinary, 2) == Integer.parseInt(changedTernary, 3)) {
                            ans = Integer.parseInt(changedBinary, 2);
                        }
                    }
                }
            }
            sb.append('#').append(testcase).append(' ')
                    .append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static String makeNewBinary(String original, int idx) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            if (i == idx) {
                builder.append(original.charAt(i) == '0' ? '1' : '0');
            } else {
                builder.append(original.charAt(i));
            }
        }
        return builder.toString();
    }

    static String makeNewTernary(String original, int idx, int target) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            if (i == idx) {
                builder.append(target);
            } else {
                builder.append(original.charAt(i));
            }
        }
        return builder.toString();
    }
}
