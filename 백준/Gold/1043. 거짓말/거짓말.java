import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        boolean[] isKnowTruth = new boolean[n+1];
        // 진실을 아는 사람 큐에 삽입
        if (truthCount > 0) {
            for (int i = 0; i < truthCount; i++) {
                int participant = Integer.parseInt(st.nextToken());
                queue.offerLast(participant);
                isKnowTruth[participant] = true;
            }
        }
        // 각 파티를 Set으로 하고 참가자들 저장
        List<Set<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int participants = Integer.parseInt(st.nextToken());
            for (int j = 0; j < participants; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(set);
        }
        boolean[] mustTellTruthInParty = new boolean[m];
        // 맨 처음 진실을 아는 참가자가 참가하는 파티에서는 진실을 말해야 하고
        // 거기서 진실을 들었던 참가자들이 참가하는 파티에서도 진실만을 말해야 함 == 큐에 삽입하여 반복
        while (!queue.isEmpty()) {
            int knowTruth = queue.removeFirst();
            for (int i = 0; i < m; i++) {
                Set<Integer> party = parties.get(i);
                if (!party.contains(knowTruth)) {
                    continue;
                }
                mustTellTruthInParty[i] = true;
                for (int participant : party) {
                    if (!isKnowTruth[participant]) {
                        queue.offerLast(participant);
                        isKnowTruth[participant] = true;
                    }
                }
            }
        }
        int count = 0;
        for (boolean flag : mustTellTruthInParty) {
            if(!flag) {
                ++count;
            }
        }
        System.out.println(count);
    }
}
