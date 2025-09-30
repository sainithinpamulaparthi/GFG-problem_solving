import java.util.*;

class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> res = new ArrayList<>();
        int total = 1 << n; // 2^n
        for (int i = 0; i < total; i++) {
            String bin = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            res.add(bin);
        }
        return res;
    }
}
