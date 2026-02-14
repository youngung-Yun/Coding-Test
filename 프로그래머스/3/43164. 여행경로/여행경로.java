import java.util.*;

class Solution {
    
    boolean foundRoute = false;
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        // 티켓 수
        int n = tickets.length;
        
        Arrays.sort(tickets, (s1, s2) -> {
            if (s1[0].compareTo(s2[0]) == 0) {
                return s1[1].compareTo(s2[1]);
            }
            return s1[0].compareTo(s2[0]);
        });
        
        String[] airports = new String[n+1];
        airports[0] = "ICN";
        dfs("ICN", new boolean[n], airports, 0, n, tickets);        
        return answer;
    }
    
    public void dfs(String curr, boolean[] visited, String[] arr, int depth, int n, String[][] tickets) {
        if (foundRoute) {
            return;
        }
        if (depth == n) {
            foundRoute = true;
            answer = Arrays.copyOf(arr, n + 1);
            return;
        }     
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (!tickets[i][0].equals(curr)) {
                continue;
            }
            visited[i] = true;
            arr[depth+1] = tickets[i][1];
            dfs(tickets[i][1], visited, arr, depth + 1, n, tickets);
            visited[i] = false;
        }
    }
}