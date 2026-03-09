import java.io.*;
import java.util.*;

public class Solution {
    static int n;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    static int count(int x,int y){
        int c=0;
        for(int d=0; d<8; d++){
            int nx=x+dx[d];
            int ny=y+dy[d];
            if(nx>=0 && ny>=0 && nx<n && ny<n && map[nx][ny]=='*') c++;
        }
        return c;
    }

    static void bfs(int x,int y){
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{x,y});
        visit[x][y]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cx=cur[0];
            int cy=cur[1];

            if(count(cx,cy)!=0) continue;

            for(int d=0; d<8; d++){
                int nx=cx+dx[d];
                int ny=cy+dy[d];

                if(nx<0||ny<0||nx>=n||ny>=n) continue;
                if(visit[nx][ny] || map[nx][ny]=='*') continue;

                visit[nx][ny]=true;
                if(count(nx,ny)==0) q.add(new int[]{nx,ny});
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            n=Integer.parseInt(br.readLine());
            map=new char[n][n];
            visit=new boolean[n][n];

            for(int i=0;i<n;i++) map[i]=br.readLine().toCharArray();

            int ans=0;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j]=='.' && !visit[i][j] && count(i,j)==0){
                        bfs(i,j);
                        ans++;
                    }
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j]=='.' && !visit[i][j]) ans++;
                }
            }

            System.out.println("#"+tc+" "+ans);
        }
    }
}