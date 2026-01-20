import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            // Set에 배의 주기 저장
            // 해당 주기에 해당하는 배가 없으면 Set에 추가
            for (int i = 0; i < n; i++) {
                int happyDay = Integer.parseInt(br.readLine());
                if (happyDay == 1) {
                    continue;
                }
                int frequency = happyDay - 1;
                boolean exists = false;
                for (int e : set) {
                    if (frequency % e == 0) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    set.add(frequency);
                }
            }
            sb.append('#').append(testCase).append(' ').append(set.size()).append('\n');
        }
        System.out.println(sb);
    }
}