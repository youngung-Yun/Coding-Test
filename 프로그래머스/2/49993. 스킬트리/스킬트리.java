import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String tree : skill_trees) {
            int[] indices = new int[skill.length()];
            Arrays.fill(indices, 30);
            for (int i = 0; i < tree.length(); i++) {
                char ch = tree.charAt(i);
                for (int k = 0; k < skill.length(); k++) {
                    if (ch == skill.charAt(k)) {
                        indices[k] = i;
                    }
                }
            }
            boolean canLearn = true;
            for (int i = 1; i < indices.length; i++) {
                if (indices[i-1] > indices[i]) {
                    canLearn = false;
                    break;
                }
            }
            if (canLearn) {
                ++answer;
            }
        }
        return answer;
    }
}