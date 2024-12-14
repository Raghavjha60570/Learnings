import java.util.TreeMap;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int start = 0;
        long count = 0;
        
        // Use a TreeMap to track the frequency of elements in the current window
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int end = 0; end < n; end++) {
            // Add the current number to the map
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            
            // Ensure the condition |max - min| <= 2
            while (map.lastKey() - map.firstKey() > 2) {
                // Remove nums[start] from the map
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
            }
            
            // All subarrays ending at 'end' are valid
            count += (end - start + 1);
        }
        
        return count;
    }
}

