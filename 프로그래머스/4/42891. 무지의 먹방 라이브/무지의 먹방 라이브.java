import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        // 다 먹을 수 있으면 -1 리턴
        long total = 0;
        for (int time : food_times) {
            total += time;
        }
        if (total <= k) {
            return -1;
        }
        
        // 음식 양 순으로 정렬
        PriorityQueue<Food> pq = new PriorityQueue<>((f1, f2) -> {
            return f1.amount - f2.amount;
        });
        
        for (int i = 0; i < food_times.length; i++) {
            pq.add(new Food(i + 1, food_times[i]));
        }
        
        long spendTime = 0;
        long cycle = 0;
        long length = food_times.length;
        while (spendTime + (pq.peek().amount - cycle) * length <= k) {
            Food food = pq.poll();
            spendTime += (food.amount - cycle) * length;
            --length;
            cycle = food.amount;
        }
        
        List<Food> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        
        // 번호 순 정렬
        list.sort((f1, f2) -> {
            return f1.number - f2.number;
        });
        
        return list.get((int) ((k - spendTime) % length)).number;
    }
    
    static class Food {
        public int number;
        public int amount;
        
        public Food(int number, int amount) {
            this.number = number;
            this.amount = amount;
        }
    }
}