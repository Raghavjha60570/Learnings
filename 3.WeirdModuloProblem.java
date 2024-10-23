import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc  = new Scanner ( System.in);
		int t= sc.nextInt();
		while ( t-->0){
		    int n= sc.nextInt();
		    int a[]= new int[n];
		    
		   for ( int i=0 ; i<n ; i++){
		      a[i]= sc.nextInt();
		      
		   }
		    Arrays.sort(a);
            int ans=a[0]%a[1];
            for (int i = 2; i < n; i++) {
                int b = a[i];
                ans %= b;
            }
            System.out.println(ans);
		}

	}
}

