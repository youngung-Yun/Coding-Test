import java.util.*;
import java.io.*;
public class Solution {
	static int n;
	static int[][] map;
	static List<int[]> core;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int[] min;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
	
		for(int test=1;test<=t;test++) {
			n = Integer.parseInt(br.readLine().trim());
			core = new ArrayList<>();
			map = new int[n][n];
			min = new int[2];
			min[0] = Integer.MAX_VALUE;
			for(int i=0; i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n;j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
					if((j!=0&&i!=0&&j!=n-1&&i!=n-1)&&(map[i][j]==1)) {
						core.add(new int[] {j,i});
					}
				}
			}
			check(0,0,0);
			System.out.println("#"+test+" "+min[0]);
		}

	}
	static void check(int cur,int cnt ,int connedted) {
		if(cur==core.size()) {
			if(min[1]<connedted) {
				min[0] = cnt;
				min[1] = connedted;
			}else if(min[1]==connedted) {
				min[0] = Math.min(cnt, min[0]);
			}
			return;
		}
		
		check(cur+1, cnt,connedted);
		int[] curCore= core.get(cur);
		int x = curCore[0];
		int y = curCore[1];
		
		for(int i=0; i<4;i++) {
			if(canCn(x,y,i)) {
				int count = connect(x,y,i);
				check(cur+1,cnt+count,connedted+1);
				disConnect(x,y,i);
			}
		}
		
	}
	static boolean canCn(int x, int y, int dir) {
		while(x!=0&&y!=0&&x!=n-1&&y!=n-1) {
			x+=dx[dir];
			y+=dy[dir];
			if(map[y][x]==1) {
				return false;
			}else if(map[y][x]==2) {
				return false;
			}
		}
		return true;
	}
	static int connect(int x, int y, int dir) {
		int count=0;
		while(x!=0&&y!=0&&x!=n-1&&y!=n-1) {
			x+=dx[dir];
			y+=dy[dir];
			map[y][x]=2;
			count++;
			}
		return count;
		}
	static void disConnect(int x, int y, int dir) {
		while(x!=0&&y!=0&&x!=n-1&&y!=n-1) {
			x+=dx[dir];
			y+=dy[dir];
			if(map[y][x]==2)map[y][x]=0;
			}
		}
	static boolean isValid(int x, int y) {
		return !(x<0||y<0||x>=n||y>=n);
	}
		
	}

