class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(s, target, 0, 0, 0, "", res);
        Collections.sort(res);
        return res;
    }

    private void helper(String s, int target, int index, long eval, long mult, String path, ArrayList<String> res) {
        if (index == s.length()) {
            if (eval == target) res.add(path);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // avoid numbers with leading zeros
            if (i != index && s.charAt(index) == '0') break;

            String currStr = s.substring(index, i + 1);
            long curr = Long.parseLong(currStr);

            if (index == 0) {
                // first number, no operator before it
                helper(s, target, i + 1, curr, curr, currStr, res);
            } else {
                helper(s, target, i + 1, eval + curr, curr, path + "+" + currStr, res);
                helper(s, target, i + 1, eval - curr, -curr, path + "-" + currStr, res);
                helper(s, target, i + 1, eval - mult + mult * curr, mult * curr, path + "*" + currStr, res);
            }
        }
    }
}

