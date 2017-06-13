package leetcode;


/*
 Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it? 
 */

public class ReverseBits {

	// you need treat n as an unsigned value
	public int reverseBits(int n) {

		int ret = 0;
		for(int i = 0; i< 32; i++){
			ret += 1 & n; // only calculate on the lowest bit
			n >>>= 1;
			if(i<31){
				ret <<= 1;
			}
			
		}
		return ret;
		
	}

}
// 一位一位出来和1做与预算 然后乘以2进位