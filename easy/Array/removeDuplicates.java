package Array;

/**
 * @program: 26. 删除排序数组中的重复项
 * @description: 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *               不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @author: pooooi
 * @create: 2021-03-02 21:24
 **/

public class removeDuplicates {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        printNums("num1", nums1);
        printNums("num2", nums2);
    }

    private static int RDC(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    private static void printNums(String numName, int[] nums) {
        System.out.print("\n" + numName + ": ");
        int cnt = RDC(nums);
        for (int i=0; i< cnt;i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
