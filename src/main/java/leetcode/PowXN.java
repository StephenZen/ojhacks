package leetcode;

/*
 (UNSOLOVED)
 Implement pow(x, n). 
 divide and conquer
 */
public class PowXN {
	public double myPow(double x, int n) {
		double temp = x;
		if (n == 0)
			return 1;
		temp = myPow(x, n / 2);
		if (n % 2 == 0)
			return temp * temp;
		else {
			if (n > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}
}

// 递归 一直divide 到n==0