
class Solution {
    private void combine(List<List<Integer>> ans, int[] arr, int target, int i, List<Integer> list) {
        int n = arr.length;

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int a = i; a < n; a++) {
            if (a > i && arr[a] == arr[a - 1]) continue;

            if (arr[a] > target) break;

            list.add(arr[a]);
            combine(ans, arr, target - arr[a], a + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        combine(ans, arr, target, 0, new ArrayList<>());
        return ans;
    }
}
