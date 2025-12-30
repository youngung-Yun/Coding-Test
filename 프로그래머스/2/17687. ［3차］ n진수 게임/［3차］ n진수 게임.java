class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int sequence = 0;
        int current = 0;
        while (sb.length() < t) {
            String str = Integer.toString(current, n);
            for (char ch : str.toCharArray()) {
                if (sb.length() >= t) {
                    break;
                }
                if (++sequence > m) {
                    sequence -= m;
                }
                
                if (sequence == p) {
                    sb.append(Character.toUpperCase(ch));
                }
            }
            ++current;
        }
        return sb.toString();
    }
}