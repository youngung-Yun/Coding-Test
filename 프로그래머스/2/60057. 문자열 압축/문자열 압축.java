class Solution {
    public int solution(String s) {
        int answer = 1001;
        for (int length = 1; length <= s.length(); ++length) {
            StringBuilder sb = new StringBuilder();
            String partial = s.substring(0, length);
            int count = 0;
            int index = 0;
            while (index + length <= s.length()) {
                String curr = s.substring(index, index + length);
                if (partial.equals(curr)) {
                    ++count;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(partial);
                    partial = curr;
                    count = 1;
                }
                index += length;
            }
            if (count > 1) {
                sb.append(count);
            }
            sb.append(partial);
            while (index < s.length()) {
                sb.append(s.charAt(index));
                index += 1;
            }
            answer = Integer.min(answer, sb.length());
        }

        return answer;
    }
}