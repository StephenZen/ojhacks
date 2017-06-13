package leetcode;

/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
 */

public class ClimbingStairs {
	 public int climbStairs(int n) {
	        if(n==1) return 1;
	        else if(n==2) return 2;
	        else{
	            int[] count = new int[n];
	            count[0]=1;
	            count[1]=2;
	            for(int i=2; i<n; i++){
	                int a = count[i-1];
	                int b = count[i-2];
	                int c = a+b;
	                count[i] = c;
	            }
	            return count[n-1];
	        }
	    }
}

// dp 下一个等于 前一个和前前一个之和