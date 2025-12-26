class Solution {
    public int solution(String dartResult) {
        int[] points = new int[3];
        int[] bonusIndex = new int[3];
        int index = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            if (!Character.isDigit(dartResult.charAt(i))) {
                continue;
            }
            // 10인지 판별
            if (i + 1 < dartResult.length() && Character.isDigit(dartResult.charAt(i+1))) {
                points[index] = 10;
                bonusIndex[index] = i + 2;
                i++;
            } else {
                // 나머지 숫자
                points[index] = Character.getNumericValue(dartResult.charAt(i));
                bonusIndex[index] = i + 1;
            }
            ++index;
        }
        for (int i = 0; i < 3; i++) {
            char bonus = dartResult.charAt(bonusIndex[i]);
            if (bonus == 'D') {
                points[i] *= points[i];
            } else if (bonus == 'T') {
                points[i] *= points[i] * points[i];
            }
            if (bonusIndex[i] + 1 < dartResult.length()) {
                char next = dartResult.charAt(bonusIndex[i] + 1);
                if (next == '#') {
                    points[i] *= -1;
                } else if (next == '*') {
                    points[i] *= 2;
                    if (i > 0) {
                        points[i-1] *= 2;
                    }
                }
            }
        }
        return points[0] + points[1] + points[2];
    }
}