package main

/**
  存在重复元素 https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
*/
func containsDuplicate(nums []int) bool {
	set := make(map[int]bool)
	for i := 0; i < len(nums); i++ {
		if set[nums[i]] {
			return true
		} else {
			set[nums[i]] = true
		}
	}
	return false
}
