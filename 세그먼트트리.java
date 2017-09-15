/*
입력
N
N개의 수
합을 구하는 구간 L, R
바꿀 인덱스i, 새로운 수 m
6
10 11 12 13 14 15
2 4
2 5
 
 */

import java.io.FileInputStream;
import java.util.*;

public class Solution {
	static int [][] t;
	static int [] p;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		t = new int [1000000][3];
		
		int N = sc.nextInt();
		p = new int [N];
		for(int i = 0; i<N; i++)
		{
			p[i] = sc.nextInt();
		}
		int left = sc.nextInt();
		int right = sc.nextInt();
		int idx = sc.nextInt();
		int m = sc.nextInt();
		int ret = make(1, 0, N-1);
		// left~right 구간 합
		ret = sum(1, left, right);
		System.out.println(ret);
		
		// p[idx]를 m으로 변경
		change(1, idx, m);
		// left~right 구간 합
		ret = sum(1, left, right);
		System.out.println(ret);
	}
	public static int make(int n, int s, int e)
	{
		t[n][0] = s; // start
		t[n][1] = e; // end
		if(s==e) // 잎노드
		{
			t[n][2] = p[s]; // 잎노드의 sum
			return t[n][2];
		}
		else
		{
			int l = make(n*2, s, (s+e)/2); // 왼쪽 자식
			int r = make(n*2+1, (s+e)/2+1, e); // 오른쪽 자식
			t[n][2] = l+r; // sum
			return t[n][2];
		}
	}
	public static int sum(int n, int L, int R)
	{
		if (R<t[n][0] || t[n][1]<L) // 구간을 벗어남  
			return 0;
		else if(L<=t[n][0] && t[n][1]<=R) // s,e가 찾는 구간에 포함됨
			return t[n][2];
		else // 일부 겹치면 계속 검색
		{
			int r1 = sum(n*2, L, R);
			int r2 = sum(n*2+1, L, R);
			return r1+r2;
		}
	}
	public static int change(int n, int i, int m)
	{
		if(i < t[n][0] || t[n][1]<i)
			return 0;
		else if( t[n][0] == i && t[n][1] == i)
		{
			int diff = m - t[n][2];
			t[n][2] = m;
			return diff;
		}
		else
		{
			int r1 = change(n*2, i, m);
			int r2 = change(n*2+1, i, m);
			t[n][2] += (r1+r2);
			return r1+r2;
		}
	}
}
