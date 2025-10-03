class Solution {
    static String[] keypad = {
        "",    // 0
        "",    // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs",// 7
        "tuv", // 8
        "wxyz" // 9
    };

    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        backtrack(arr, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int[] arr, int index, StringBuilder current, ArrayList<String> result) {
        if (index == arr.length) {
            if (current.length() > 0) result.add(current.toString());
            return;
        }

        String letters = keypad[arr[index]];
        if (letters == null || letters.length() == 0) {
            // skip digits like 0 and 1 that don't map to letters
            backtrack(arr, index + 1, current, result);
            return;
        }

        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(arr, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
