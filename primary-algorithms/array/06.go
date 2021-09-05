package main

import "fmt"

/**
  两个数组的交集 II https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
*/
func main() {
	ints := intersect([]int{4, 9, 5}, []int{9, 4, 9, 8, 4})
	fmt.Println(ints)
}

// there have more than one solution.
func intersect(nums1 []int, nums2 []int) []int {
	maps := make(map[int]int)
	for i := 0; i < len(nums1); i++ {
		maps[nums1[i]] += 1
	}
	maps2 := make(map[int]int)
	for i := 0; i < len(nums2); i++ {
		if maps[nums2[i]] > 0 {
			maps[nums2[i]] -= 1
			maps2[nums2[i]] += 1
		}
	}
	res := make([]int, 0)
	for k, v := range maps2 {
		for i := 0; i < v; i++ {
			res = append(res, k)
		}
	}
	return res
}
