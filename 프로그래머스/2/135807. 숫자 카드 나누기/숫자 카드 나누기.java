class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // 배열마다 모든 요소의 최대공약수 구함
        // 그 최대공약수가 다른 배열의 모든 요소에 나누어 떨어지지 않는지 확인
        int l = arrayA.length;
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for (int i = 1; i < l; i++) {
            gcdA = getGcd(gcdA, arrayA[i]);
            gcdB = getGcd(gcdB, arrayB[i]);
        }
        for (int e : arrayB) {
            if (e % gcdA == 0) {
                gcdA = 0;
                break;
            }
        }
        for (int e : arrayA) {
            if (e % gcdB == 0) {
                gcdB = 0;
                break;
            }
        }
        
        return Integer.max(gcdA, gcdB);
    }
    
    static int getGcd(int a, int b) {
        int max = Integer.max(a, b);
        int min = Integer.min(a, b);
        if (min == 0) {
            return max;
        }
        return getGcd(b, a % b);
    }
}