// Very Easy 

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
         
          int min=0 ;
          int idx=0;
          for ( int j=0 ;j<k; j++){
            min=nums[0];
            idx=0;
            for (int i=0 ; i<nums.length ; i++){
                       if(nums[i]<min){
                        min= nums[i];
                        idx=i;
                 }
            }
             nums[idx]=min*multiplier;
          }

          return nums;
    }
}
