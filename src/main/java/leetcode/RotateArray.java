package leetcode;

/*
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 Hint:
 Could you do it in-place with O(1) extra space?

 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - k- 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        
    }

    void reverse(int[] num, int left, int right) {
        while (left < right) {
            int t = num[left];
            num[left] = num[right];
            num[right] = t;
            left++;
            right--;
        }
    }
}

//先将k取模, 因为超过一圈了还会调回来
//将k前段,后端颠倒顺序,然后整个颠倒 就将恢复正常顺序 