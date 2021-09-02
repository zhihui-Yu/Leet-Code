package main

import "fmt"

/**
  买卖股票的最佳时机 II link https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
*/
func main() {
	profit := maxProfit([]int{7, 1, 5, 3, 6, 4})
	fmt.Println(profit)
}

func maxProfit(prices []int) int {
	length := len(prices)
	if length <= 1 {
		return 0
	}
	dp := make([][2]int, length)
	// 没持股的收益
	dp[0][0] = 0
	// 持股的收益
	dp[0][1] = -prices[0]
	for i := 1; i < length; i++ {
		// 没持股 = max ( 前一天没买入的收益，今天卖出的收益 ）
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
		// 持股的收益 = max ( 前一天持股的收益，今天买入持股 ）
		dp[i][1] = max(dp[i-1][1], dp[i][0]-prices[i])
	}
	// 最后一天没持股
	return dp[length-1][0]
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
