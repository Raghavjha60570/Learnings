import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner ( System.in);
		int t= sc.nextInt();
		
		while ( t-->0){
		    int n= sc.nextInt();
		    int  x= sc.nextInt()-1;
		  int y= sc.nextInt()-1;
		  
		  if ( n==1){
		      System.out.println(0);
		  }
		  else {
		      int count=0 ; 
		      //for row horizontally
		      count +=(n-1);
		      
		      //for columns vertically
		      
		      count+=n-1;
		      
		      //diagonals
		      
		      count+=Math.min(x,y); // top right diagonals
		      count+=Math.min(x,n-y-1);// top left diagonals
		      //bottom right diagonal
		      count+=Math.min(n-x-1,y);
		      //bottom left diagonal
		      count+=Math.min(n-x-1,n-y-1);
		      
		      System.out.println(count);
		      
		  }
	}

	}
}
