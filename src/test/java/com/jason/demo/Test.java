package com.jason.demo;

/**
 * @author: jason
 * @Date: 2020-08-04
 */
public class Test {
    public static void main(String[] args) {
        int nums[] = new int[4];
        nums[0] = 2;
        nums[1] = 7;
        nums[2] = 11;
        nums[3] = 15;
        int target = 9;
        System.out.println("args = [" + twoSum(nums, target) + "]");
    }

    public static int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i]!=nums[j] && nums[i] + nums[j] == target) {
                    res[0] = nums[i];
                    res[1] = nums[j];
                    return res;
                }
            }
        }
        return res;
    }
}
