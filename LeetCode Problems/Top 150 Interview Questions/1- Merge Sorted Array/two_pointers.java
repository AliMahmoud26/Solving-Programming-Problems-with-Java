// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
// -------------------------------------------------------------------------------------------------------
// Example 1:
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

// Solution of the problem - Two Pointers (Forward Approach with Copy Array):
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of the first m elements of nums1
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }
        
        int p1 = 0;      // pointer for nums1Copy
        int p2 = 0;      // pointer for nums2
        int p = 0;       // pointer for nums1 (final merged array)
        
        // Merge while both arrays have elements
        while (p1 < m && p2 < n) {
            if (nums1Copy[p1] <= nums2[p2]) {
                nums1[p] = nums1Copy[p1];
                p1++;
            } else {
                nums1[p] = nums2[p2];
                p2++;
            }
            p++;
        }
        
        // Copy remaining elements from nums1Copy if any
        while (p1 < m) {
            nums1[p] = nums1Copy[p1];
            p1++;
            p++;
        }
        
        // Copy remaining elements from nums2 if any
        while (p2 < n) {
            nums1[p] = nums2[p2];
            p2++;
            p++;
        }
    }
}

public class two_pointers {
    public static void main(String[] args) {
        // Test case 1: Example from problem
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        
        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);
        
        System.out.print("Merged array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();  // Expected output: 1 2 2 3 5 6
    }
}