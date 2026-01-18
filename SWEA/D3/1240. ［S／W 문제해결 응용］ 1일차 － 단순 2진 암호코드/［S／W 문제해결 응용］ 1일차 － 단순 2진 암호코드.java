import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Character> cipherMap = new HashMap<>();
        cipherMap.put("0001101", '0');
        cipherMap.put("0011001", '1');
        cipherMap.put("0010011", '2');
        cipherMap.put("0111101", '3');
        cipherMap.put("0100011", '4');
        cipherMap.put("0110001", '5');
        cipherMap.put("0101111", '6');
        cipherMap.put("0111011", '7');
        cipherMap.put("0110111", '8');
        cipherMap.put("0001011", '9');
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String[] cryptogram = new String[n];
            for (int i = 0; i < n; i++) {
                cryptogram[i] = br.readLine();
            }
            StringBuilder code = new StringBuilder();
            for (String row : cryptogram) {
                if (code.length() > 0) {
                    break;
                }
                for (int start = 0; start < m - 56; start++) {
                    if (code.length() > 0) {
                        break;
                    }
                    // 7글자 모두 일치하는지 확인
                    for (int i = start; i < start + 56; i += 7) {
                        String partial = row.substring(i, i + 7);
                        if (!cipherMap.containsKey(partial)) {
                            code.setLength(0);
                            break;
                        }
                        code.append(cipherMap.get(partial));
                    }
                }
            }
            // 검증
            int oddSum = 0;
            int evenSum = 0;
            for (int i = 0; i < code.length(); i++) {
                int digit = Character.getNumericValue(code.charAt(i));
                if ((i + 1) % 2 == 0) {
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
            }
            sb.append('#').append(testCase).append(' ')
                    .append(((oddSum * 3) + evenSum) % 10 == 0 ? evenSum + oddSum : 0).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}