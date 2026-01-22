import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        // 캘 수 있는 섹션 수 = 총 곡괭이 수와 광물 개수를 5로 나눈 몫 중 더 작은 수
        int sectionCount = Integer.min(picks[0] + picks[1] + picks[2],
                                      (int) Math.ceil(minerals.length / 5.0));
        
        PriorityQueue<Section> pq = new PriorityQueue<>();
        // 1. 각 섹션에 대해 다이아몬드, 철, 돌의 개수 구함
        for (int start = 0; start < sectionCount; start++) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            for (int i = 0; i < 5; i++) {
                if (start * 5 + i >= minerals.length) {
                    break;
                }
                String mineral = minerals[start * 5 + i];
                if (mineral.equals("diamond")) {
                    diamond += 1;
                } else if (mineral.equals("iron")) {
                    iron += 1;
                } else {
                    stone += 1;
                }
            }
            // 2. 다이아몬드 개수 내림차순, 철 개수 내림차순, 돌 개수 내림차순으로 우선순위 큐에 넣음
            pq.add(new Section(diamond, iron, stone));
        }
        // 3. 다이아 곡괭이부터 차례대로 우선순위 큐에서 뽑은 광물들을 캠
        int index = 0;
        while (!pq.isEmpty()) {
            while (picks[index] == 0) {
                index += 1;
            }
            Section section = pq.poll();
            int tired;
            if (index == 0) {
                tired = section.diamond + section.iron + section.stone;
            } else if (index == 1) {
                tired = (section.diamond * 5) + section.iron + section.stone;
            } else {
                tired = (section.diamond * 25) + (section.iron * 5) + section.stone;
            
            }
            answer += tired;
            picks[index] -= 1;
        }
        
        return answer;
    }
    
    static class Section implements Comparable<Section> {
        public int diamond;
        public int iron;
        public int stone;
        
        public Section(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
        
        @Override
        public int compareTo(Section other) {
            if (this.diamond == other.diamond) {
                if (this.iron == other.iron) {
                    return -Integer.compare(this.stone, other.stone);
                }
                return -Integer.compare(this.iron, other.iron);
            }
            return -Integer.compare(this.diamond, other.diamond);
        }
    }
}