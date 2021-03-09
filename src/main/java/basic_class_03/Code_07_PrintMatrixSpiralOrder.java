package basic_class_03;

//转圈打印矩阵
//【题目】
//给定一个整型矩阵matrix，请按照转圈的方式打印它。
//例如：
//1   2  3  4
//5   6  7  8
//9  10 11 12
//13 14 15 16
//打印结果为：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10
//【要求】
//额外空间复杂度为O(1)。
public class Code_07_PrintMatrixSpiralOrder {

	public static void printMatrixSpiralOrder(int[][] arr) {
		if (arr == null) {
			return;
		}
		int rows = arr.length - 1;
		int cols = arr[0].length - 1;
		int start = 0;
		while (start <= rows && start <= cols) {
			printOneCircle(arr, start++, rows--, cols--);
		}
		System.out.println();
	}

	private static void printOneCircle(int[][] arr, int start, int rows, int cols) {
		// 按行打印
		if (start == rows) {
			while (start <= cols) {
				System.out.print(arr[rows][start++] + ",");
			}
		} else if (start == cols) { // 按列打印
			while (start <= rows) {
				System.out.print(arr[start++][cols] + ",");
			}
		} else {
			int i = start;
			while (i < cols) {
				System.out.print(arr[start][i++] + ",");
			}
			i = start;
			while (i < rows) {
				System.out.print(arr[i++][cols] + ",");
			}
			i = cols;
			while (i > start) {
				System.out.print(arr[rows][i--] + ",");
			}
			i = rows;
			while (i > start) {
				System.out.print(arr[i--][start] + ",");
			}
		}
	}

	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		// 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
		printMatrixSpiralOrder(arr1);
		int[][] arr2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		// 1,2,3,6,9,12,11,10,7,4,5,8
		printMatrixSpiralOrder(arr2);
		int[][] arr3 = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
		// 1,2,4,6,8,7,5,3
		printMatrixSpiralOrder(arr3);

	}
}
