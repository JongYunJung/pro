import java.io.FileInputStream;
import java.util.*;
public class Solution {
	static int [][] d;
	static int [][] m;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			int N = sc.nextInt();
			d = new int [N+1][4];
			m = new int [N+1][4];
			for(int i = 1; i<=N; i++)
			{
				for(int j = 1; j<=3; j++)
				{
					m[i][j] = sc.nextInt();
				}
			}
			d[1][1] = m[1][1];
			d[1][2] = m[1][2];
			d[1][3] = m[1][3];
			for(int i=2; i<=N; i++)
			{
				d[i][1] = ((d[i-1][2]<d[i-1][3])?d[i-1][2]:d[i-1][3]) + m[i][1];
				d[i][2] = ((d[i-1][1]<d[i-1][3])?d[i-1][1]:d[i-1][3]) + m[i][2];
				d[i][3] = ((d[i-1][1]<d[i-1][2])?d[i-1][1]:d[i-1][2]) + m[i][3];
			}
			int min = d[N][1]<d[N][2]?d[N][1]:d[N][2];
			min = min<d[N][3]?min:d[N][3];

			System.out.println("#"+tc+" "+min);
		}
	}
}
