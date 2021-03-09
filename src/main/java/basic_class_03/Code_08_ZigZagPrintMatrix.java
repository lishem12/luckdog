package basic_class_03;

//“之”字形打印矩阵
//【题目】
//给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，例如：
//1  2  3  4
//5  6  7  8
//9 10 11 12
//“之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
public class Code_08_ZigZagPrintMatrix {

	public static void zigZagPrintMatrix(int[][] arr) {
		if(arr==null) {
			return;
		}
		int p1row = 0;
		int p1col = 0;
		int p2row = 0;
		int p2col = 0;
		int temp;
		boolean flag = true;
		while( p1col>= p2col && p1row <=  p2row) {
			printSingleline(arr,p1row,p1col,p2row,p2col,flag);
			temp = p1col==arr[0].length-1? ++p1row:++p1col;
			temp = p2row==arr.length-1? ++p2col:++p2row;
			flag = !flag;
		}
		System.out.println();
	}
	
	
    private static void printSingleline(int[][] arr, int p1row, int p1col, int p2row, int p2col,boolean flag)  {
		if(flag) {
			while(p2col<=p1col) {
				System.out.print(arr[p2row--][p2col++]+",");
			}
		}else {
			while(p1row<=p2row) {
				System.out.print(arr[p1row++][p1col--]+",");
			}
		}
	}



	public static void main(String[] args) {
        int[][] arr1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        // 1,2,5,9,6,3,4,7,10,13,14,11,8,12,15,16
        zigZagPrintMatrix(arr1);
        int[][] arr2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        // 1,2,4,7,5,3,6,8,10,11,9,12
        zigZagPrintMatrix(arr2);
        int[][] arr3 = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        //1,2,3,5,4,6,7,8
        zigZagPrintMatrix(arr3);
    }
}
