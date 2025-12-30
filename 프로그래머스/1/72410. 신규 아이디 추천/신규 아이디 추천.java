class Solution {
    public String solution(String new_id) {
        // 1
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        // 2
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (!isValidCharacter(ch)) {
                continue;
            }
            if (i > 0 && ch == '.' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
                continue;
            }
            sb.append(ch);
        }
        // 4
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        // 5
        if (sb.length() == 0) {
            sb.append('a');
        }
        // 6
        if (sb.length() >= 16) {
            sb.delete(15, sb.length());            
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        // 7
        if (sb.length() <= 2) {
            char last = sb.charAt(sb.length() - 1);
            while (sb.length() < 3) {
                sb.append(last);
            }
        }
        return sb.toString();
    }
    
    private static boolean isValidCharacter(char ch) {
        if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
            return true;
        }
        if (ch == '-' || ch == '_' || ch == '.') {
            return true;
        }
        return false;
    }
}