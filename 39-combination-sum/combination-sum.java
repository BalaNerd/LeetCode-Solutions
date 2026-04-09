class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void backtrack(int[] arr, int remain, int idx, List<Integer> path, List<List<Integer>> ans) {
        if (remain == 0) {
            ans.add(new ArrayList<>(path)); 
            return;
        }
        if (idx == arr.length || remain < 0) return; 
        path.add(arr[idx]);
        backtrack(arr, remain - arr[idx], idx, path, ans);
        path.remove(path.size() - 1);
        backtrack(arr, remain, idx + 1, path, ans);
    }
}