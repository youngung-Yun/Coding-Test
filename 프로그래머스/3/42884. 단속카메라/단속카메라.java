import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (a1, a2) -> Integer.compare(a1[1], a2[1]));
        
        /*
         * 1. 진출 위치 기준 오름차순 정렬
         * 2. 현재 차량 경로에 카메라 설치
         * 3. 진입 지점이 현재 진출 지점보다 먼저면 같이찍힘
         * 4. 차량 경로 밖이면 2번부터 반복
        */
        
        int cameraCount = 0;
        int exitPoint = -30_001;
        
        for (int[] route : routes) {
            int entryPoint = route[0];
            if (exitPoint < entryPoint) {
                ++cameraCount;
                exitPoint = route[1];
            }
        }
        
        return cameraCount;
    }
}