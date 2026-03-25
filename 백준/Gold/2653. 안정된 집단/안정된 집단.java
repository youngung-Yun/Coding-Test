import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[][] relation = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int c = 0; c < n; c++) {
                relation[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        // 나와 같은 그룹 : 나와 싫어하는 사람과 좋아하는 사람이 모두 같음
        List<List<Integer>> groups = new ArrayList<>();
        boolean[] checked = new boolean[n];
        int count = 0;
        for (int curr = 0; curr < n; curr++) {
            if (checked[curr]) {
                continue;
            }
            List<Integer> group = new ArrayList<>();
            for (int other = 0; other < n; other++) {
                boolean isSame = true;
                for (int target = 0; target < n; target++) {
                    if (relation[curr][target] != relation[other][target]) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    checked[other] = true;
                    group.add(other);
                }
            }
            if (group.size() > 1) {
                groups.add(group);
                count += group.size();
            }
        }

        if (count < n) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(groups.size()).append('\n');
        for (List<Integer> group : groups) {
            for (int person : group) {
                sb.append(person + 1).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}