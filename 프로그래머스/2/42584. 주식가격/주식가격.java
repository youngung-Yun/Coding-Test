import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Stock> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            while (!stack.isEmpty() && stack.peek().price > price) {
                Stock stock = stack.pop();
                answer[stock.index] = i - stock.index;
            }
            stack.push(new Stock(i, price));
        }
        while (!stack.isEmpty()) {
            Stock stock = stack.pop();
            answer[stock.index] = prices.length - 1 - stock.index;
        }
        
        return answer;
    }
    
    static class Stock {
        public int index;
        public int price;
        
        public Stock(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }
}