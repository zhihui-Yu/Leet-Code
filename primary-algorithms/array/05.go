package main

/**
  只出现一次的数字  https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
*/
func singleNumber(nums []int) int {
	// a ^ a = 0
	var res int
	for i := 0; i < len(nums); i++ {
		res = res ^ nums[i]
	}
	return res
}
