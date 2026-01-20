import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Map<String, Long> lottoMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String pattern = st.nextToken();
                long prize = Long.parseLong(st.nextToken());
                lottoMap.put(pattern, prize);
            }
            long total = 0L;
            for (int i = 0; i < m; i++) {
                String lotto = br.readLine();
                total += findLottoPrize(lottoMap, lotto);
            }
            sb.append('#').append(testCase).append(' ').append(total).append('\n');
        };
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static long findLottoPrize(Map<String, Long> map, String lotto) {
        for (String pattern : map.keySet()) {
            boolean isMatching = true;
            for (int i = 0; i < 8; i++) {
                if (pattern.charAt(i) == '*') {
                    continue;
                }
                if (pattern.charAt(i) != lotto.charAt(i)) {
                    isMatching = false;
                    break;
                }
            }
            if (isMatching) {
                return map.get(pattern);
            }
        }
        return 0L;
    }
}