import java.io.*;
import java.util.*;
import java.math.*;
class mergeSort
{
	public static void main( String args [])
	{
		PrintWriter	pw=new PrintWriter( System.out,true);
		int a[]={5,2,56,4,15,6,37,8};								//array to sort
		mSort(a,0,a.length);
		for(int i=0; i<a.length; i++)
		{
			pw.println(a[i]+" ");
		}		
	}
	public static void mSort(int a[], int p, int r)
	{
		int q=0;
		if(p<r)
		{
			q=(p+r)/2;
			mSort(a, p,q);			//Apply recursive algo to first half of array
			mSort(a,q+1,r);			//Apply recursive algo to second half of array
			mSort(a,p,q,r);			//Call sorting algo
		}
	}
	public static void mSort(int a[], int p, int q, int r)
	{
		int ar[]=new int[a.length];
		for(int i=p; i<r; i++)
		{
			ar[i]=a[i];
		}
		int st=p,m=q+1,l=p;
		while(st<=q && m<r)
		{
			if(ar[st]<=ar[m])
			{
				a[l]=ar[st];
				st++;
			}
			else
			{
				a[l]=ar[m];
				m++;
			}
		}
		while(st<=q)
		{
			a[l]=ar[st];
			l++;
			st++;
		}	
	}
}
