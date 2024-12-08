import java.util.*;

public class Solution {
    public int maxTwoEvents(int[][] events) {
        // Step 1: Sort events based on their end time
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        
        // Step 2: Maintain the maximum value of single events encountered so far
        int maxSingleEventValue = 0;
        int result = 0;
        
        // Use a TreeMap to store end time and max value up to that point
        TreeMap<Integer, Integer> maxValueUpToEnd = new TreeMap<>();
        
        for (int[] event : events) {
            int start = event[0], end = event[1], value = event[2];
            
            // Find the largest value of non-overlapping event ending before 'start'
            Integer prevEnd = maxValueUpToEnd.floorKey(start - 1);
            int maxNonOverlappingValue = prevEnd != null ? maxValueUpToEnd.get(prevEnd) : 0;
            
            // Update result considering current event
            result = Math.max(result, value + maxNonOverlappingValue);
            
            // Update maximum single event value
            maxSingleEventValue = Math.max(maxSingleEventValue, value);
            
            // Update TreeMap with the current max value up to this event's end time
            maxValueUpToEnd.put(end, Math.max(maxValueUpToEnd.getOrDefault(end, 0), maxSingleEventValue));
        }
        
        return result;
    }
}
