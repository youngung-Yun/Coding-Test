import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[] grades = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean[] visited = new boolean[n * 100 + 1];
            visited[0] = true;
            for (int grade : grades) {
                List<Integer> list = new ArrayList<>();
                // 앞선 점수들에 현재 점수를 더한 경우의 수들 계산
                for (int i = 0; i < visited.length - grade; i++) {
                    if (visited[i]) {
                        list.add(i + grade);
                    }
                }
                for (int idx : list) {
                    visited[idx] = true;
                }
            }

            int answer = 0;
            for (boolean b : visited) {
                if (b) {
                    answer += 1;
                }
            }

            sb.append('#').append(testCase).append(' ').append(answer).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}