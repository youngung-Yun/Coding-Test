import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] parent;

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        // 재귀로 경로 압축
        parent[x] = find(parent[x]);

        return parent[x];
    }

    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        parent[parentY] = parentX;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        int[] truthPeople = new int[truthCount];
        for (int i = 0; i < truthCount; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }
        // 진실을 아는 사람 같은 그룹으로 묶기
        for (int i = 1; i < truthCount; i++) {
            union(truthPeople[0], truthPeople[i]);
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            parties.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int participantCount = Integer.parseInt(st.nextToken());
            List<Integer> party = parties.get(i);
            for (int j = 0; j < participantCount; j++) {
                int participant = Integer.parseInt(st.nextToken());
                party.add(participant);
            }
            // 파티 참가자들을 같은 그룹으로 묶기
            for (int j = 1; j < participantCount; j++) {
                union(party.get(0), party.get(j));
            }
        }

        int result = 0;
        for (List<Integer> party : parties) {
            boolean canTellLies = true;
            // 파티 참가자 중 진실을 아는 사람과 같은 그룹인 사람이 있으면
            // 그 파티에서는 진실을 말할 수 없음
            for (int participant : party) {
                if (truthCount > 0 && find(participant) == find(truthPeople[0])) {
                    canTellLies = false;
                    break;
                }
            }
            if (canTellLies) {
                ++result;
            }
        }
        System.out.println(result);
    }
}
