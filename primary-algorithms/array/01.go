package main

import "fmt"

func main() {
	res := removeDuplicates([]int{1, 1, 2, 3})
	res2 := removeDuplicates([]int{})
	fmt.Println(res)
	fmt.Println(res2)
}

func removeDuplicates(nums []int) int {
	left := 0
	right := 0
	numsLen := len(nums)
	if numsLen < 1 {
		return 0
	}
	for right < numsLen-1 {
		right++
		if nums[left] == nums[right] {
			continue
		} else {
			left = left + 1
			temp := nums[right]
			nums[right] = nums[left]
			nums[left] = temp
		}
	}
	return left + 1
}
