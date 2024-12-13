class Solution {
    public long findScore(int[] nums) {
      int n = nums.length;
        boolean[] marked = new boolean[n]; // Array to track marked elements
        long score = 0;

        // Create a 2D array to store the values and their indices
        int[][] indexedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexedNums[i][0] = nums[i]; // Value
            indexedNums[i][1] = i;      // Index
        }

        // Sort the array by value first, and by index for tie-breaking
        Arrays.sort(indexedNums, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // Process the sorted elements
        for (int[] pair : indexedNums) {
            int value = pair[0];
            int index = pair[1];

            // Skip if already marked
            if (marked[index]) {
                continue;
            }

            // Add value to score
            score += value;

            // Mark the current element and its adjacent elements
            marked[index] = true;
            if (index > 0) {
                marked[index - 1] = true;
            }
            if (index < n - 1) {
                marked[index + 1] = true;
            }
        }

        return score;
           
        }
    }

