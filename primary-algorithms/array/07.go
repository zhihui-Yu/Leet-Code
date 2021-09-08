package main

import "fmt"

/**
  加一  https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
*/
func main() {
	fmt.Println(plusOne([]int{1, 2, 3}))
	fmt.Println(plusOne([]int{4, 3, 2, 1}))
	fmt.Println(plusOne([]int{0}))
	fmt.Println(plusOne([]int{9, 9, 9, 9}))
	fmt.Println(plusOne([]int{8, 9, 9, 9}))
}

func plusOne(digits []int) []int {
	//return solutionForTheAns(digits)
	// the following is my mind
	l := len(digits)
	if digits[l-1] != 9 {
		digits[l-1] += 1
		return digits
	}
	carry := 0
	index := l - 1
	for index >= 0 && digits[index] == 9 {
		carry += 1
		index -= 1
	}

	index = 0
	if carry == l {
		res := make([]int, l+1)
		for i := 0; i < l+1; i++ {
			if i == 0 {
				res[i] = 1
			} else {
				res[i] = 0
			}
		}
		return res
	} else {
		res := make([]int, l)
		for i := l - 1; i >= 0; i-- {
			if carry > 0 {
				res[i] = 0
			} else if carry == 0 {
				res[i] = digits[i] + 1
			} else {
				res[i] = digits[i]
			}
			carry -= 1
		}
		return res
	}
}

func solutionForTheAns(digits []int) []int {
	l := len(digits)
	for i := l - 1; i >= 0; i-- {
		if digits[i] != 9 {
			digits[i] += 1
			return digits
		} else {
			digits[i] = 0
		}
	}
	res := make([]int, l+1)
	res[0] = 1
	return res
}
