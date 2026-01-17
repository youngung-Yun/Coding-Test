class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] extraServers = new int[24];
        for (int time = 0; time < 24; ++time) {
            int player = players[time];
            int needServer = (player / m) - extraServers[time];
            if (needServer > 0) {
                answer += needServer;
                for (int t = 0; t < k; t++) {
                    if (time + t >= 24) {
                        break;
                    }
                    extraServers[time + t] += needServer;
                }
            }
        }
        return answer;
    }
}