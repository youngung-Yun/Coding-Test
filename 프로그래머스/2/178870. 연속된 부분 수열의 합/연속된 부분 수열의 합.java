class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0, sequence.length};
        
        int left = 0;
        int sum = 0;
        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            while (left < right && sum > k) {
                sum -= sequence[left];
                ++left;
            }
            if (sum == k) {
                // 길이가 더 짧은 수열 선택
                if (answer[1] - answer[0] > right - left) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        return answer;
    }
}