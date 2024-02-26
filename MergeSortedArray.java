public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Initialize the pointers
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;

        // Merge nums2 into nums1 starting from the end
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
            i--;
        }

        // Copy any remaining elements from nums2 into nums1
        while (p2 >= 0) {
            nums1[i] = nums2[p2];
            i--;
            p2--;
        }
    }

    // more refined approach



    public static void mergeRefinedApproach(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

}


