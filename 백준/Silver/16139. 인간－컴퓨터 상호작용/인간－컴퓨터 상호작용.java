import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] prefixSum = makePrefixSum(str);

        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().split(" ");
            char ch = input[0].charAt(0);
            int left = Integer.parseInt(input[1]);
            int right = Integer.parseInt(input[2]);
            int index = ch - 'a';

            int count;
            if (left > 0) {
                count = prefixSum[index][right] - prefixSum[index][left - 1];
            }
            else {
                count = prefixSum[index][right];
            }
            sb.append(count).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // 미리 알파벳 26개에 대한 구간합 계산
    private static int[][] makePrefixSum(String string) {
        int[][] result = new int[26][string.length()];

        for (int i = 0; i < string.length(); i++) {
            if (i == 0) {
                result[string.charAt(0) - 'a'][0] = 1;
                continue;
            }

            for (int k = 0; k < 26; k++) {
                if (string.charAt(i) - 'a' == k) {
                    result[k][i] = result[k][i - 1] + 1;
                }
                else {
                    result[k][i] = result[k][i - 1];
                }
            }
        }

        return result;
    }
}