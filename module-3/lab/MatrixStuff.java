import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class MatrixStuff {

	public static void main(String[] args) {

		int[][] matrix;
		matrix = new int[50][20];
		int[][] colmatrix;
		colmatrix = new int[50][20];
		fillArrayRowMajor(matrix);
		System.out.println("\nThe largest integer in the array is: " + findMax(matrix));
		System.out.println("The smallest integer in the array is: " + findMin(matrix));
		System.out.println("The largest integer in that row is: " + findMaxOfRow(matrix, 5));
		System.out.println("The smallest integer of that row is: " + findMinOfRow(matrix, 49));
		System.out.println("The largest integer of that column is: " + findMaxOfColumn(matrix, 10));
		System.out.println("The smallest integer of that column is: " + findMinOfColumn(matrix, 13));
		fillArrayColumnMajor(colmatrix);
		System.out.println();
		printRow(matrix, 10, 5);
		System.out.println();
		System.out.println("The row with the smallest amount of change is row " + smallestChange(matrix));
	}

	public static void fillArrayRowMajor(int[][] array) {
		try {
			File numFile = new File("number_list.txt");
			Scanner scanner = new Scanner(numFile);
			for(int i = 0; i < 50; i++) {
				for(int j = 0; j < 20; j++) {
					array[i][j] = scanner.nextInt();
				}
			}
			scanner.close();
		}
		catch(FileNotFoundException fnf) {
			System.out.println("ERROR: File Not Found");
		}
	}
	public static int findMax(int[][] array) {
		int max;
		max = array[0][0];

		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				if(array[i][j] > max) {
					max = array[i][j];
				}
			}
		}
		return max;

	}
	public static int findMin(int[][] array) {
		int min;
		min = array[0][0];

		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				if(array[i][j] < min) {
					min = array[i][j];
				}
			}
		}
		return min;
	}
	public static int findMaxOfRow(int[][] array, int row) {
		int max;
		max = array[row][0];

		for(int i = 0; i < array[0].length; i++) {
			if(array[row][i] > max) {
				max = array[row][i];
			}
		}
		return max;
	}
	public static int findMinOfRow(int[][] array, int row) {
		int min;
		min = array[row][0];

		for(int i = 0; i < array[0].length; i++) {
			if(array[row][i] < min) {
				min = array[row][i];
			}
		}
		return min;
	}
	public static int findMaxOfColumn(int[][] array, int column) {
		int max;
		max = array[0][column];

		for(int i = 0; i < array.length; i++) {
			if(array[i][column] > max) {
				max = array[i][column];
			}

		}
		return max;
	}
	public static int findMinOfColumn(int[][] array, int column) {
		int min;
		min = array[0][column];

		for(int i = 0; i < array.length; i++) {
			if(array[i][column] < min) {
				min = array[i][column];
			}
		}
		return min;
	}
	public static void fillArrayColumnMajor(int[][] array) {

			int r = 0;
			int c = 0;

			try {
				File numFile = new File("number_list.txt");
				Scanner scanner = new Scanner(numFile);
				while(scanner.hasNextInt()) {
					array[r][c] = scanner.nextInt();
					r++;
					if(r == 50) {
						c++;
						r = 0;
						if(c == 20) {
							break;
						}
					}



			}
				scanner.close();
			}
			catch(FileNotFoundException fnf) {
				System.out.println("ERROR: File Not Found");
			}
	}
	public static void printRow(int[][] array, int row, int num_cols) {
		int limit = num_cols;
		int lcount = 0;

		for(int i = 0; i <= 19; i++) {
			System.out.print(array[row][i] + " ");
			lcount++;

			if(lcount >= limit) {
				System.out.println();
				lcount = 0;
				}
		}

	}
	public static int smallestChange(int[][] array) {
		int num1;
		int num2;
		int diff;
		int roll = 0;
		int min = 0;
		int rowx = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length - 1; j++) {
				num1 = array[i][j];
				num2 = array[i][j+1];
				if(num1 > num2) {
					diff = num1 - num2;
					roll += diff;
				}
				else if(num2 > num1) {
					diff = num2 - num1;
					roll += diff;
			}
				 if(j == 18) {
					 if(i == 0) {
						 min = roll;
						 roll = 0;
					 }
					 else if(i != 0) {
						 if(roll < min) {
							 min = roll;
							 roll = 0;
							 rowx = i;
						 }
						 else if(roll > min) {
							 roll = 0;
						 }
					 }
				 }
			}

		}
		return rowx;

	}

}
