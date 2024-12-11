class Solution {
    public int maximumBeauty(int[] nums, int k) {
      Arrays.sort(nums);
        int left = 0;
        int maxBeauty = 0;

       
        for (int right = 0; right < nums.length; right++) {
         
            while (nums[right] - k > nums[left] + k) {
                left++;
            }
            
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }

        return maxBeauty;
    }
}
