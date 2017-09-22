import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [][] t;
	static int [][] d;
	static int N;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++)
		{
		
			N = sc.nextInt();
			t = new int [N+1][N+1];
			d = new int [N+1][1<<(N+1)];
			
			for(int i=1; i<=N; i++)
			{
				for(int j=1; j<=N; j++)
				{
					t[i][j] = sc.nextInt();
				}
				for(int j = 0; j<(1<<(N+1)); j++)
				{
					d[i][j] = Integer.MAX_VALUE;
				}
					
			}

			// 경유지 없는 경우. (0은 경유지 집합이 공집합인 경우)
			for(int i=2; i<=N; i++)
			{
				d[i][0] = t[i][1];
			}
			// 1을 제외하고 모든 경유지 선택
			// N=5인경우
			// 1<<6 : 1000000
			// -1 :   0111111
			// &(~3) :0111100 -> {2,3,4,5}
			
			int ret = find(1, (((1<<(N+1))-1)&(~3)));
			
			System.out.println("#"+tc+" "+ret);
		}
	}
	// n은 출발지, s는 경유지 집합의 원소를 표시하는 이진수
	public static int find(int n, int s)
	{
		if(s==0)
		{
			return d[n][0];
		}
		else if(d[n][s]!= Integer.MAX_VALUE)
			return d[n][s];
		else
		{
			int min = Integer.MAX_VALUE;
			int ret = 0;
			for(int i = 2; i<=N; i++)
			{
				if((s&(1<<i)) != 0)
				{
					// s&(~(1<<i) : s에서 i를 제외
					ret = t[n][i] + find(i, s&(~(1<<i))); 
					if(min>ret)
						min = ret;
				}
			}
			d[n][s] = min;
			return min;
		}
	}
}
