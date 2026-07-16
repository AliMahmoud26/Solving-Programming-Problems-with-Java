// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
// Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.
// The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

// Example 1:
// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).

import java.util.Arrays;

public class remove_duplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0; // If the array is empty, return 0
        }

        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
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