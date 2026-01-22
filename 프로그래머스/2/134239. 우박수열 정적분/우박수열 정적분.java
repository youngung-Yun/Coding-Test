import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        // 1. 우박수열 구함
        // 2. 범위 계산
        // 2-1. n-b = (x.length() - 1 - b)
        // 2-2. 시작점 a가 이 값보다 크면 유효하지 않으므로 결과는 -1
        // 3. 정적분 결과 계산
        //   - 아래부분: x와 x+1중 작은 값 * 1인 직사각형
        //   - 윗부분: 밑변이 1이고 높이가 |f(x) - f(x+1)| 인 직각삼각형
        
        List<Integer> sequence = new ArrayList<>();
        // 1.
        sequence.add(k);
        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            sequence.add(k);
        }
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            // 2.
            int start = range[0];
            int end = sequence.size() - 1 + range[1];
            if (start > end) {
                answer[i] = -1.0;
                continue;
            }
            // 3.
            double area = 0.0;
            for (int x = start; x < end; x++) {
                int rectangle = Integer.min(sequence.get(x), sequence.get(x + 1));
                int deltaY = Math.abs(sequence.get(x) - sequence.get(x + 1));
                double triangle = 1.0 * deltaY / 2.0;
                area += (rectangle + triangle);
            }
            answer[i] = area;
        }
        
        return answer;
    }
}