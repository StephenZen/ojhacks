package leetcode;

/*
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
 * 1,2,3 1,1,5 → 1,5,1
 */

public class NextPermutation {
	public void nextPermutation(int[] num) {
		int n = num.length;
		if (n == 0 || n == 1)
			return;
		int index = n - 1;
		while (index > 0) {
			if (num[index] > num[index - 1]) {
				break;
			}
			index--;
		}
		if (index == 0) {
			reverse(num, 0, n - 1);
			return;
		} else {
			int left = index - 1;
			while (index < n && num[index] > num[left]) {
				index++;
			}
			int right = index - 1;
			exchange(num, left, right);
			reverse(num, left + 1, n - 1);
		}
	}

	void exchange(int[] num, int l, int r) {
		int tmp = num[r];
		num[r] = num[l];
		num[l] = tmp;
	}

	void reverse(int[] num, int i, int j) {
		while (i < j) {
			exchange(num, i, j);
			i++;
			j--;
		}

	}
}

// 从右往左处理 直到遇到比左位大停止, 记录此左位 
// 若一直未停, 反转整个数组
// 否则在向右扫, 知道碰到比左位小的停止, 记录此右位
// 将这段区域反转