
import java.util.*;
import java.io.*;
public class Solution {
	static int n;
	static int m;
	static int k;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static List<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=t;test++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 list.clear();
			 n=Integer.parseInt(st.nextToken());
			 m=Integer.parseInt(st.nextToken());
			 k=Integer.parseInt(st.nextToken());
			 
			 for(int i=0; i<k;i++) {
				 st = new StringTokenizer(br.readLine());
				 int y = Integer.parseInt(st.nextToken());
				 int x = Integer.parseInt(st.nextToken());
				 int cnt = Integer.parseInt(st.nextToken());
				 int dir = Integer.parseInt(st.nextToken())-1;
				 list.add(new int[] {y,x,cnt,dir});
			 }
			 
			 for(int i=0; i<m;i++) {
				 move();
				 merge();
			 }
			 int total=0;
			 for(int i=0; i<list.size();i++) {
				 total+=list.get(i)[2];
			 }
			 sb.append("#").append(test).append(" ").append(total).append("\n");
			 
			 
		}
		System.out.print(sb);
	}
	static boolean check(int x, int y) {
		return x==0||y==0||x==n-1||y==n-1;
	}
	static void move() {
		for(int i=list.size()-1;i>=0;i--) {
			int[] cur = list.get(i);
			int x = cur[1];
			int y = cur[0];
			int cnt = cur[2];
			int dir = cur[3];
			
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			cur[1] = nx;
			cur[0] = ny;
			if(check(nx,ny)) {
				cur[2]=cur[2]/2;
				
				if(dir==0) {
					cur[3]=1;
				}else if(dir==1) {
					cur[3]=0;
				}else if(dir==2) {
					cur[3]=3;
				}else if(dir==3) {
					cur[3]=2;
				}
				
				
			}
			if(cur[2]==0) {
				list.remove(i);
			}
		}
	}
	static void merge() {
		Map<Integer,List<int[]>>group = new HashMap<>();
		
		for(int[] cur : list) {
			int x = cur[1];
			int y = cur[0];
			int key = y*n+x;
			group.computeIfAbsent(key, k -> new ArrayList<>()).add(cur);
		}
		list.clear();
		for(List<int[]> a : group.values()) {
			if(a.size()==1) {
				list.add(a.get(0));
				continue;
			}
			int sum=0; 
			int max =0;
			int dir =0;
			int x = a.get(0)[1];
			int y =a.get(0)[0];
			
			for(int[] cur : a) {
				sum+=cur[2];
				if(max<cur[2]) {
					max= cur[2];
					dir = cur[3];
				}
			}
			list.add(new int[] {y,x,sum,dir});
		}
	}
		
}
	
	