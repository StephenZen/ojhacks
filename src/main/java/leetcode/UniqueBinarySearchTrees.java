package leetcode;

/*
 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.
 */

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {

		if (n == 0)
			return 1;
		if (n == 1)
			return 1;

		int sum = 0;

		for (int i = 0; i <= n - 1; i++) {
			sum += numTrees(i) * numTrees(n - 1 - i);
		}

		return sum;

	}
}

// 定一个root 根据乘法原则， 总数为 左树枝的个数 乘以 右树枝的个数