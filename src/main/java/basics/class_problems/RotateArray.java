package main.java.basics.class_problems;

import java.util.Arrays;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {

        k = k % nums.length;

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int newPosition = (i + k) % nums.length;

            result[newPosition] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] result = rotateArray(nums, k);

        System.out.println(Arrays.toString(result));
    }
}