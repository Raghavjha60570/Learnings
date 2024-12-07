class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
         
        int left = 1, right = Integer.MIN_VALUE;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        
     
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (canDistribute(nums, maxOperations, mid)) {
                result = mid; 
                right = mid - 1;
            } else {
                left = mid + 1; 
                    }
        }
        return result;
    }
    
    private boolean canDistribute(int[] nums, int maxOperations, int maxBalls) {
        int totalOps = 0;
        for (int balls : nums) {
            if (balls > maxBalls) {
                totalOps += (balls - 1) / maxBalls; 
            }
            if (totalOps > maxOperations) {
                return false; 
            }
        }
        return true;
    }
}