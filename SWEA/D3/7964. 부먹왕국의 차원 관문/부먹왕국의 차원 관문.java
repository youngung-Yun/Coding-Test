import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            int[] cities = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 각 도시 순회
            // 그 도시에 차원문 있으면 end를 i + distance로 갱신
            // 없으면 차원문 + 1 하고 end를 i + distance로 갱신
            int count = 0;
            int end = distance - 1;
            for (int city = 0; city < n; ++city) {
                if (cities[city] == 1) {
                    end = city + distance;
                } else {
                    if (end == city) {
                        ++count;
                        end = city + distance;
                    }
                }
            }
            sb.append('#').append(testCase).append(' ').append(count).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}