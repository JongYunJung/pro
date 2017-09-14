import java.util.Scanner;
import java.io.FileInputStream;

public class Main {
	static int [][] d;
	static int N; 
	static int [] a;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		d = new int[N+1][3];
		a = new int[N+1];
		for(int i=1; i<=N; i++)
		{
			a[i] = sc.nextInt();
		}
		int tmp;
		d[1][0] = 0;
		d[1][1] = a[1];
		d[1][2] = a[1];
		for(int i=2; i<=N; i++)
		{
			tmp = d[i-1][0]>d[i-1][1]?d[i-1][0]:d[i-1][1];
			d[i][0] = tmp>d[i-1][2]?tmp:d[i-1][2];
			d[i][1] = d[i-1][0]+a[i];
			d[i][2] = d[i-1][1]+a[i];
				
		}
		tmp = d[N][0]>d[N][1]?d[N][0]:d[N][1];
		tmp = tmp>d[N][2]?tmp:d[N][2];
		System.out.println(tmp);
	}
}
