package leetcode;

/*
 * (unsolved)
 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique. 
 */

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {

		int previous = 0;
		int index = 0;
		int restGas = 0;
		for (int i = 0; i < gas.length; i++) {
			restGas += gas[i] - cost[i];

			if (restGas < 0) {
				previous += restGas;
				restGas = 0;
				index = i + 1;
			}
		}

		if (restGas + previous >= 0) {
			return index;
		} else {
			return -1;
		}
	}
}

// 贪心, 如果剩余油量为负数,就保存之前剩余有量,重置index, 遍历玩一圈, 如果剩余油量加上之前油量不为正, 则表示总油量不够, 否则return最后最大的index.