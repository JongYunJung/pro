import java.io.FileInputStream;
import java.util.Scanner;


public class Solution {
	static int [] d;
	static int [] u;
	static int [][] adj;
	static int V, E;
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			d = new int [V+1];
			u = new int [V+1];
			adj = new int [V+1][V+1];
			for (int i = 0; i <= V; i++)
			{
				for (int j = 0; j <= V; j++)
				{
					if (i == j)
						adj[i][j] = 0;
					else
						adj[i][j] = Integer.MAX_VALUE;
				}
			}
			for (int i = 0; i < E; i++)
			{
				int n1, n2, w;
				n1 = sc.nextInt();
				n2 = sc.nextInt();
				w = sc.nextInt();
				adj[n1][n2] = w;
			}
			
			bfs();
			System.out.println("#"+tc+" "+d[V]);
			
		}
		
		
		
	}
	public static void bfs()
	{
		int front = -1;
		int rear = -1;
		int [] Q = new int [V*V];
		// 시작점의 인접 노드를 enqueue, d[] 초기화
		for (int i = 0; i <= V; i++)
		{
			if (adj[0][i] != 0 && adj[0][i] != Integer.MAX_VALUE)
			{
				Q[++rear] = i;
			}
			d[i] = adj[0][i];
		}
		while (front != rear)
		{
			int t = Q[++front];
			// t를 경유지로. t와 인접인 모든 i에 대해...
			for (int i = 0; i <= V; i++)
			{
				if (adj[t][i] != 0 && adj[t][i] != Integer.MAX_VALUE)
				{
					if (d[i] > (d[t] + adj[t][i])) // 갱신이 되면
					{
						d[i] = d[t] + adj[t][i];
						Q[++rear] = i;  // 갱신된 i의 인접도 갱신될 수 있으므로 enqueue
					}

				}
			}
		}
	}
}
