class Solution {
    public int solution(int k, int[][] dungeons) {
        int result = dfs(dungeons, new boolean[dungeons.length], 0, k);
        return result;
    }
    
    private static int dfs(int[][] dungeons, boolean[] visited, int count, int tired) {
        if (tired <= 0) {
            return count;
        }
        int max = count;
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }
            int[] dungeon = dungeons[i];
            if (dungeon[0] <= tired) {
                visited[i] = true;
                max = Math.max(max, dfs(dungeons, visited, count + 1, tired - dungeon[1]));      
                visited[i] = false;
            }
        }
        return max;
    }
}