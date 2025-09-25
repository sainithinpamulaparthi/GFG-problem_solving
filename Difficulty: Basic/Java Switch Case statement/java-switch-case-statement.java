import java.util.*;

class Solution {
    static double switchCase(int choice, List<Double> arr) {
        double area = 0.0;
        switch (choice) {
            case 1: // Circle
                double R = arr.get(0);
                area = Math.PI * R * R;
                break;
            case 2: // Rectangle
                double L = arr.get(0);
                double B = arr.get(1);
                area = L * B;
                break;
            default:
                area = 0.0;
        }
        return area;
    }
}
