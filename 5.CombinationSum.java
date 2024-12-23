class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int index=0;
         List<Integer> current= new ArrayList<>();
       List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target < 0) {
            return; 
               }
        if (target == 0) {
            result.add(new ArrayList<>(current)); 
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]); 
            backtrack(candidates, target - candidates[i], i, current, result); 
            current.remove(current.size() - 1);
        }
    }    
}

  
