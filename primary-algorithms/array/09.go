package main

import "fmt"

/**
  两数之和  https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
*/

func main() {
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
}

func twoSum(nums []int, target int) []int {
	l := len(nums)
	numMap := make(map[int]int, l)
	for i := 0; i < l; i++ {
		if _, ok := numMap[target-nums[i]]; ok {
			return []int{i, numMap[target-nums[i]]}
		}
		numMap[nums[i]] = i
	}
	return []int{}
}
