// Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
// Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
// Return k after placing the final result in the first k slots of nums.
// Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

// Example 1:
// Input: nums = [1,1,1,2,2,3]
// Output: 5, nums = [1,1,2,2,3,_]
// Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).

import java.util.Arrays;

class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
        return nums.length;
        }

        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void runTest(int[] nums, int expectedK, int[] expectedNums) {
            System.out.println("\n=== Test Case ===");
            System.out.println("Input array: " + Arrays.toString(nums));
    
            int[] originalCopy = Arrays.copyOf(nums, nums.length);
            int resultK = removeDuplicates(nums);
            
            System.out.println("Expected k: " + expectedK);
            System.out.println("Actual k: " + resultK);
            System.out.println("Expected first " + expectedK + " elements: " + Arrays.toString(expectedNums));
            
            // Check first k elements
            int[] actualFirstK = Arrays.copyOf(nums, resultK);
            System.out.println("Actual first " + resultK + " elements: " + Arrays.toString(actualFirstK));
            
            // Verify
            boolean passed = (resultK == expectedK) && Arrays.equals(actualFirstK, expectedNums);
            System.out.println("Test " + (passed ? "✅ PASSED" : "❌ FAILED"));
        }
        
        public static void main(String[] args) {
            // Test Case 1: Basic duplicate removal
            runTest(
                new int[]{1, 1, 2},
                2,
                new int[]{1, 2}
            );
            
            // Test Case 2: Multiple duplicates
            runTest(
                new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
                5,
                new int[]{0, 1, 2, 3, 4}
            );
            
            // Test Case 3: No duplicates
            runTest(
                new int[]{1, 2, 3, 4, 5},
                5,
                new int[]{1, 2, 3, 4, 5}
            );
            
            // Test Case 4: All elements are the same
            runTest(
                new int[]{2, 2, 2, 2, 2},
                1,
                new int[]{2}
            );
            
            // Test Case 5: Single element array
            runTest(
                new int[]{5},
                1,
                new int[]{5}
            );
            
            // Test Case 6: Empty array
            runTest(
                new int[]{},
                0,
                new int[]{}
            );
            
            // Test Case 7: Negative numbers
            runTest(
                new int[]{-3, -3, -2, -1, -1, 0, 1, 1, 2},
                6,
                new int[]{-3, -2, -1, 0, 1, 2}
            );
            
            // Test Case 8: Large numbers (within constraints)
            runTest(
                new int[]{100, 100, 50, 50, 25, 25, 25},  // Note: This is NOT sorted!
                0,  // This will fail because the array is not sorted
                new int[]{}
            );
    }
}
