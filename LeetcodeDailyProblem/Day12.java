import java.util.Scanner;
 public class fibbonaci{
        public static void main(String args[]){

                Scanner sc = new Scanner ( System.in);
                int t = sc.nextInt();

          while ( t-->0){

            int n= sc.nextInt()
            int prev1=1;
            int prev2=0;

            for (int i=0 ; i<n ; i++){
              if(i>2){
                 int curr= prev1+prev2;
                 prev2= prev1;
                 prev1=curr;
               
                System.out.println(curr + " ");
              }else if(n==2){
                Sytsem.out.println(prev1 + " ");
              }else {
                System.out.println(prev2 + " ");
              }
            }
          }
    }
 }
                      
