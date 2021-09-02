package main

import "fmt"

/**
  旋转数组 link: https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
*/
func main() {
	//ints := []int{1, 2, 3, 4, 5, 6, 7}
	ints := []int{1, 2}
	rotate(ints, 1)
	fmt.Println(ints)
}

func rotate(nums []int, k int) {
	length := len(nums)
	k = k % length
	if length <= 1 || k == 0 {
		return
	}
	numsCopy := make([]int, length)
	copy(numsCopy, nums)
	index := 0
	for i := 0; i < length; i++ {
		if k > 0 {
			nums[i] = numsCopy[length-k]
			k--
		} else {
			nums[i] = numsCopy[index]
			index++
		}
	}
}
