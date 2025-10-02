class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int n, int k, int start) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (n < 0 || k < 0) return;

        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtrack(res, temp, n - i, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
