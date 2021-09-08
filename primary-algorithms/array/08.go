package main

/**
  移动零  https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
*/
func moveZeroes(nums []int) {
	zeroIndex := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			tmp := nums[i]
			nums[i] = nums[zeroIndex]
			nums[zeroIndex] = tmp
			zeroIndex += 1
		}
	}
}
