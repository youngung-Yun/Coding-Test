class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int digit = storey % 10;
            storey /= 10;
            
            if (digit == 5) {
                // 5는 다음 자리 수 계산하여
                // 5 이상이면 carry 더해서 횟수 아낄 수 있음
                if (storey % 10 >= 5) {
                    answer += digit;
                    ++storey;
                } else {
                    answer += digit;
                }
            } else if (digit < 5) {
                // 0, 1, 2, 3, 4는 내려가는게 이득
                answer += digit;
            } else {
                // 6. 7. 8. 9는 올라가는게 이득
                answer += (10 - digit);
                ++storey;
            }
        }
        return answer;
    }
}