import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 우선순위 저장할 최대힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // 큐
        Deque<Process> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            pq.add(priority);
            queue.offerLast(new Process(i, priority));
        }
        int order = 0;
        while (true) {
            Process first = queue.removeFirst();
            if (first.priority < pq.peek()) {
                queue.offerLast(first);
            } else {
                pq.poll();
                ++order;
                if (first.index == location) {
                    break;
                }
            }
        } 
        return order;
    }
    
    private static class Process {
        public int index;
        public int priority;
        
        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}