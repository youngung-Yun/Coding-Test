class Solution {
    public int solution(int[] numbers, int target) {
        int n = numbers.length;
        return dfs(numbers, target, 0, 0, n);
    }
    
    private static int dfs(int[] numbers, int target, int depth, int sum, int limit) {
        if (depth == limit) {
            return sum == target ? 1 : 0;
        }
        int number = numbers[depth];
        return dfs(numbers, target, depth + 1, sum + number, limit) +
            dfs(numbers, target, depth + 1, sum - number, limit);
    }
}