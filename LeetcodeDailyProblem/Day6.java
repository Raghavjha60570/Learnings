class Solution {
    public long pickGifts(int[] gifts, int k) {
        for (int i=0 ; i<k ; i++){
             int n= gifts.length;
             Arrays.sort(gifts);
             gifts[n-1]= (int )Math.sqrt(gifts[n-1]);

        }
        int n= gifts.length;
        long sum=0;
        for ( int i=0 ;i<n ;i++){
            sum+=gifts[i];
        }

        return sum;
    }
}
