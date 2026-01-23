class Solution {
    public int solution(String name) {
        // 1. 현재 위치에서 이동 + 알파벳 변경까지 가장 적게 걸리는 위치 구함
        // 2. 그만큼 조작하고 현재 위치 변경
        // 3. 반복
        int l = name.length();
        int answer = 0;
        int move = l * 2;
        for (int i = 0; i < l; i++) {
            answer += getMinChange(name.charAt(i));
            // i 이후 처음 만나는 'A'가 아닌 문자 위치
            int next = i + 1;    
            while (next < l && name.charAt(next) == 'A') {
                next += 1;
            }
            // 0번에서 i까지 오른쪽으로 이동 후 유턴하여 next까지 이동
            move = Integer.min(move, 2 * i + (l - next));
            // 0턴에서 next까지 왼쪽으로 이동 후 유턴하여 i까지 이동
            move = Integer.min(move, (l - next) * 2 + i);
        }
        answer += move;
        return answer;
    }
    private int getMinChange(char target) {
        int a = 0;
        int b = target - 'A';
        return Integer.min(b - a, (a + 26) - b);
    }
}