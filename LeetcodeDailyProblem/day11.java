import java.util.*;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
      
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[] {i, freq[i]}); 
                
            }
        }

        
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll(); 
            char ch1 = (char) ('a' + first[0]);
            int count1 = first[1];

            int add = Math.min(repeatLimit, count1); 
            for (int i = 0; i < add; i++) {
                result.append(ch1);
            }
            count1 -= add;

            if (count1 > 0) {
                if (maxHeap.isEmpty()) {
                    break;
                        }

                int[] second = maxHeap.poll();
                char ch2 = (char) ('a' + second[0]);
                int count2 = second[1];

                result.append(ch2); 
                count2--;


                 if (count2 > 0) {
                    maxHeap.offer(new int[] {second[0], count2});
                }
                maxHeap.offer(new int[] {first[0], count1});
            }
        }

        return result.toString();
    }

  
}
