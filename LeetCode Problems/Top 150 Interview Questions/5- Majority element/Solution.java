// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// Example 1:
// Input: nums = [3,2,3]
// Output: 3

// Example 2:
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2


public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            } else {
                count += (num == candidate) ? 1 : -1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Majority Element: " + solution.majorityElement(nums1)); // Expected: 3
        
        // Test Case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + solution.majorityElement(nums2)); // Expected: 2
        
        // Test Case 3
        int[] nums3 = {1};
        System.out.println("Majority Element: " + solution.majorityElement(nums3)); // Expected: 1
        
        // Test Case 4
        int[] nums4 = {6, 5, 5};
        System.out.println("Majority Element: " + solution.majorityElement(nums4)); // Expected: 5

        // Test Case 5
        int[] nums5 = {3, 3, 4};
        System.out.println("Majority Element: " + solution.majorityElement(nums5)); // Expected: 3
}}