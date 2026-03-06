import java.util.*;
import java.io.*;

public class Main {
	
	static List<Integer>[] list;
	static int n;
	static boolean[] select;
	static int result;
	static int[] pop;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n  =Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		select = new boolean[n+1];
		pop = new int[n+1];
		result = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n;i++) {
			list[i] = new ArrayList<>();
			pop[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0; j<cnt;j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		subset(1);
			if(result == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(result);
		
	}
	static void subset(int cnt) {
		if(cnt==n+1) {
			List<Integer> g1 = new ArrayList<>();
			List<Integer> g2 = new ArrayList<>();
			
			for(int i=1; i<=n;i++) {
			if(select[i])g1.add(i);
			else g2.add(i);	
			}
			if(g1.size()==0 || g2.size()==0 ) return;
			if(bfs(g1)&&bfs(g2)) {
				int g1Sum=0;
				int g2Sum=0;
				for(int i=0; i<g1.size();i++) {
					g1Sum += pop[g1.get(i)];
				}
				for(int i=0; i<g2.size();i++) {
					g2Sum += pop[g2.get(i)];
				}
				result = Math.min(result, Math.abs(g1Sum-g2Sum));
			}
			
			return;
		}
		select[cnt]  =true;
		subset(cnt+1);
		select[cnt]  =false;
		subset(cnt+1);
	}
	static boolean bfs(List<Integer> group) {
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[n+1];
		q.add(group.get(0));
		visit[group.get(0)] = true;
		int count=1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int a : list[cur]) {
				if(!visit[a]&&group.contains(a)) {
					count++;
					q.add(a);
					visit[a] = true;
				}
			}
		}
		return count==group.size();
	}
	
		
	}
	