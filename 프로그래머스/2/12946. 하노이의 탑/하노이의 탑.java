import java.util.*;

class Solution {
    
    static List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoiTower(n, 1, 3, 2);
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private void hanoiTower(int count, int from, int to, int pass) {
        if (count == 1) {
            list.add(new int[] {from, to});
            return;
        }
        
        hanoiTower(count - 1, from, pass, to);
        hanoiTower(1, from, to, pass);
        hanoiTower(count - 1, pass, to, from);
    }
}