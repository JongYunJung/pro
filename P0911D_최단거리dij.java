import java.io.FileInputStream;
import java.util.Scanner;


public class Solution {
	static int [] d;
	static int [] u;
	static int [][] adj;
	static int V, E;
	// for dij()
	static int [][] Q;
	static int last;
	static int [] t;
	
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
			dij();
			System.out.println("#"+tc+" "+d[V]);	
		}
	}
	// 단순반복
	public static void dij2()
	{
		u[0] = 1;
		for(int i=0; i<=V; i++)
			d[i] = adj[0][i];
		int cnt = 0;
		while(cnt<V)
		{
			// u[i] == 0 이고 d[i]가 최소인 i찾기..
			int t = 0;
			int minV = Integer.MAX_VALUE;
			for(int i=0; i<=V; i++)
			{
				if(u[i]==0 && d[i]<minV)
				{
					minV = d[i];
					t = i;
				}
			}
			// 새로운 경유지 결정
			u[t] = 1;
			for(int i=0; i<=V; i++)
			{
				if(adj[t][i]!=0 && adj[t][i]!=Integer.MAX_VALUE)
				{
					d[i] = d[i]>(d[t]+adj[t][i])?(d[t]+adj[t][i]):d[i];
				}
			}
			
			cnt++;
		}
	}
	
	public static void dij()
	{
		last = 0;
		t = new int [3]; // dequeue된 값을 저장
		Q = new int [E+1][3];
		u[0] = 1;
		for(int i=1; i<=V; i++)
		{
			if(adj[0][i]!=0 && adj[0][1]!=Integer.MAX_VALUE)
			{
				enQ(0, i, adj[0][i]);
			}
			d[i] = adj[0][i];
		}
		while(last>0)
		{
			deQ(); // t[]로 디큐됨...
			u[t[1]] = 1;
			for(int i=0; i<=V; i++)
			{
				if(adj[t[1]][i]!=0 && adj[t[1]][i]!=Integer.MAX_VALUE)
				{
					if (d[i] > (d[t[1]] + adj[t[1]][i])) // 갱신이 되면
					{
						d[i] = d[t[1]] + adj[t[1]][i];
						enQ(t[1], i, adj[t[1]][i]);
					}
				}
			}
		}
	}
	
	public static void enQ(int n1, int n2, int w)
	{
		int c = ++last;
		int p = c / 2;
		//Q[c] = n;
		Q[last][0] = n1;
		Q[last][1] = n2;
		Q[last][2] = w;
		while( c > 1 && Q[p][2] > Q[c][2] )
		{

			for(int i=0; i<3; i++)
			{
				Q[0][i] = Q[p][i];
				Q[p][i] = Q[c][i];
				Q[c][i] = Q[0][i];
			}
			c= p;
			p = p/2;
		}	
	}
	
	public static void deQ()
	{
		t[0] = Q[1][0];
		t[1] = Q[1][1];
		t[2] = Q[1][2];
		// root <- Q[last]
		for(int i=0; i<3; i++)
		{
			Q[1][i] = Q[last][i];
		}
		
		last--;
		int p = 1;
		while(p<last)
		{
			int c1 = p * 2;
			int c2 = p * 2 + 1;
			if(c2<=last)
			{
				int c = Q[c1][2]<Q[c2][2]?c1:c2;
				if( Q[c][2] < Q[p][2] )
				{
					for(int i=0; i<3; i++)
					{
						Q[0][i] = Q[p][i];
						Q[p][i] = Q[c][i];
						Q[c][i] = Q[0][i];
					}
					p = c;
				}
				else
					break;
			}
			else if(c1<=last)
			{
				if(Q[c1][2]<Q[p][2])
				{
					for(int i=0; i<3; i++)
					{
						Q[0][i] = Q[p][i];
						Q[p][i] = Q[c1][i];
						Q[c1][i] = Q[0][i];
					}
					p = c1;
				}
				else
					break;
			}
			else
				break;
		}
		
	}
}
