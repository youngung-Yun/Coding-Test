import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        List<Candidate> frames = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            boolean isInFrames = false;
            int minRecommendedCount = 1_001;
            int minRecommendedIndex = 0;
            for (int i = 0; i < frames.size(); i++) {
                Candidate candidate = frames.get(i);
                // 리스트에 있으면 추천 횟수 1 증가
                if (candidate.number == number) {
                    ++candidate.recommendedCount;
                    isInFrames = true;
                    break;
                }
                // 추천 받은 횟수 가장 적은 후보의 인덱스 구함
                if (candidate.recommendedCount < minRecommendedCount) {
                    minRecommendedCount = candidate.recommendedCount;
                    minRecommendedIndex = i;
                }
            }
            if (!isInFrames) {
                // 사진틀이 다 찼으면 추천 가장 적은 후보 빼고 넣음
                if (frames.size() >= n) {
                    frames.remove(minRecommendedIndex);
                }
                // 사진틀 남으면 그냥 넣음
                frames.add(new Candidate(number, 1));
            }
        }
        frames.sort((r1, r2) -> Integer.compare(r1.number, r2.number));
        StringBuilder sb = new StringBuilder();
        for (Candidate c : frames) {
            sb.append(c.number).append(' ');
        }
        System.out.println(sb);
    }

    static class Candidate {
        public int number;
        public int recommendedCount;

        public Candidate(int number, int recommendedCount) {
            this.number = number;
            this.recommendedCount = recommendedCount;
        }
    }
}