package tag.array;

public class ContainerWithMostWater {
    // https://leetcode.com/problems/container-with-most-water/description/
    public int maxArea(int[] height) {
        // return bruteForce(height);
        return doublePointer(height);
    }

    private int bruteForce(int[] height) {
        int n = height.length;

        int max = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    private int doublePointer(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;

        int max = 0;
        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if(height[left] <= height[right]) left++;
            else right--;
            max = Math.max(max, area);
        }

        return max;
    }
}
