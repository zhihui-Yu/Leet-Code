package main

func rotate(matrix [][]int)  {
	mLen := len(matrix)


	//先上下交换
	for (int mLen = 0; mLen < length / 2; mLen++) {
		int temp[] = matrix[mLen];
		matrix[mLen] = matrix[length -mLen- 1];
		matrix[length -mLen- 1] = temp;
	}
	//在按照对角线交换
	for (int mLen = 0; mLen < length; ++mLen) {
		for (int j = mLen + 1; j < length; ++j) {
			int temp = matrix[mLen][j];
			matrix[mLen][j] = matrix[j][mLen];
			matrix[j][mLen] = temp;
		}
	}
}