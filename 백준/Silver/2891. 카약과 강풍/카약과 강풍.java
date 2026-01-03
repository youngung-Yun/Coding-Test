import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        boolean[] canLend = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int e = Integer.parseInt(st.nextToken());
            set.add(e);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int e = Integer.parseInt(st.nextToken());
            if (set.contains(e)) {
                set.remove(e);
            } else {
                canLend[e] = true;
            }
        }
        int[] brokens = set.stream().mapToInt(Integer::intValue).sorted().toArray();
        // 자신의 앞 순서 팀에게 빌리는 것이 다음 순서 팀에게 빌리는 것보다 우선순위가 높다.
        // 이유: 오름차순으로 진행하기 때문에, 앞 순서 팀에게 빌릴 수 있다는 것은 앞 앞 순서 팀이
        // 빌릴 필요가 없거나 이미 빌렸다는 것이기 때문에 내가 빌려도 손해가 없음
        // 그러나 뒤 순서 팀에게 빌리면 그 뒤 순서 팀이 못빌릴 수도 있기 때문에 우선순위가 더 낮음.
        int answer = 0;
        for (int broken : brokens) {
            if (broken - 1 >= 0 && canLend[broken - 1]) {
                canLend[broken - 1] =  false;
            } else if (broken + 1 <= n && canLend[broken + 1]) {
                canLend[broken + 1] = false;
            } else {
                ++answer;
            }
        }
        System.out.println(answer);
    }
}
