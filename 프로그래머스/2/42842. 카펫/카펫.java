class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) {
                continue;
            }
            int height = i;
            int width = yellow / i;
            int brownWidth = (width + 2);
            int brownHeight = (height + 2);
            int brownArea = (brownWidth * brownHeight) - yellow;
            if (brownArea == brown) {
                result[0] = brownWidth;
                result[1] = brownHeight;
                break;
            }
        }
        return result;
    }
}