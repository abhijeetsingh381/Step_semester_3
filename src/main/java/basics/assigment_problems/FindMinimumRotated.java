package main.java.basics.assigment_problems;

public class FindMinimumRotated {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {

                // Minimum is on right side
                left = mid + 1;

            } else {

                // Minimum is on left side
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(findMin(nums));
    }
}