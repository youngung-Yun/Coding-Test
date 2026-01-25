import java.util.*;

class Solution {
    
    static Set<String> candidates = new HashSet<>();
    
    public int solution(String[][] relation) {
        int length = relation[0].length;
        
        bfs(relation, 0, length, 0, new int[length]);
        
        return getComplyMinimalityKey();
    }
    
    // 선택 가능한 모든 컬럼 조합에 대해 유일성을 만족 하는지 확인
    private void bfs(String[][] relation, int depth, int n, int curr, int[] array) {

        for (int i = curr; i < n; i++) {
            array[depth] = i;
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k <= depth; k++) {
                sb.append(array[k]);
            }            
            if (canBeCandidateKey(relation, array, depth)) {
                // 유일성 만족하면 set에 넣음
                candidates.add(sb.toString());
                continue;
            }
            bfs(relation, depth + 1, n, i + 1, array);
            
        }
    }
    
    private boolean canBeCandidateKey(String[][] relation, int[] array, int depth) {
        Set<String> set = new HashSet<>();
        for (String[] tuple : relation) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= depth; i++) {
                int idx = array[i];
                String value = tuple[idx];
                sb.append(value).append(' ');
            }
            // 중복되는 값이 있어서 후보키가 될 수 없음
            sb.deleteCharAt(sb.length() - 1);
            if (set.contains(sb.toString())) {
                return false;
            }
            set.add(sb.toString());
        }
        return true;
    }
    
    // 유일성 만족하는 후보키 중 최소성도 만족하는 후보키의 개수 계산
    private int getComplyMinimalityKey() {
        String[] arr = candidates.stream().toArray(String[]::new);
        Arrays.sort(arr, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        
        System.out.println(Arrays.toString(arr));
                    
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            String a = arr[i];
            boolean complyMinimality = true;
            for (int k = i + 1; k < arr.length; k++) {
                String b = arr[k];
                int matchCount = 0;
                for (char ch : b.toCharArray()) {
                    if (a.indexOf(ch) != -1) {
                        matchCount += 1;
                    }
                }
                // 해당 후보키가 다른 후보키의 모든 컬럼을 포함하면 그 후보키는 최소성을 만족하지 않음
                if (matchCount == b.length()) {
                    complyMinimality = false;
                    break;
                }
            }
            if (complyMinimality) {
                count += 1;
            }
        }
        return count;
    }
}