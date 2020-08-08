package com.zsp1987.leetcode;

/*
 Count the number of prime numbers less than a non-negative number, n.
 */

public class CountPrimes {
	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i < n; i++) {
			if (!isPrime[i])
				continue;
			for (int j = i * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i])
				count++;
		}
		return count;
	}
}

// Sieve of Eratosthenes
// 从2到根�?�n的数(因为 n=p*q, where p<q, 所以最大的因�?应该是根�?�n), �?次递加该数直到n, 将覆盖到的数标记
// 最终没有被覆盖的数就是质数