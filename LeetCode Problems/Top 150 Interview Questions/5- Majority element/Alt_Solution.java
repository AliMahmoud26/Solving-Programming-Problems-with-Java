public class Alt_Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
    
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Alt_Solution solution = new Alt_Solution();

        // Test Case 1
        int[] nums1 = {6, 5, 5};
        System.out.println("Majority Element: " + solution.majorityElement(nums1)); // Expected: 5

        // Test Case 2
        int[] nums2 = {3, 3, 4};
        System.out.println("Majority Element: " + solution.majorityElement(nums2)); // Expected: 3
}}
