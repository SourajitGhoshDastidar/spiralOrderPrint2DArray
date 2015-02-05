package spiralOrderPrint2DArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*Given a “n x m” array (n & m could be different or same numbers), print the contents of the array in a spiral order
 *  (i.e. print the outermost elements followed by the 
 *  next inner layer followed by the next inner 
 *  layer and so on until all elements are printed) in a clockwise manner. 
 *  Note that all elements of the array should be printed only once.
 The input could be either read from a text file or from a command prompt and the output should be printed on a console.
 Example 1:
 Array contents:
 A b c d e 1 
 F g h I j 2
 K l m n o 3
 P q r s t 4
 Output: a b c d e 1 2 3 4 t s r q p k f g h l j o n l m
 Example 2:
 Array contents:
 1   2   3   4
 5   6   7   8
 9 10 11 12
 Output: 1 2 3 4 8 12 11 10 9 5 6 7*/

public class SpiralPrint2DArray {

	public static void spiralOrder(ArrayList<ArrayList<String>> matrix) {
		if (matrix.size() == 0)
			return;
		// Initialize our four indexes
		int top = 0;
		int down = matrix.size() - 1;
		int left = 0;
		int right = matrix.get(0).size() - 1;

		while (true) {
			// Print top row
			for (int j = left; j <= right; ++j)
				System.out.print(matrix.get(top).get(j) + " ");
			top++;
			if (top > down || left > right)
				break;
			// Print the rightmost column
			for (int i = top; i <= down; ++i)
				System.out.print(matrix.get(i).get(right) + " ");
			right--;
			if (top > down || left > right)
				break;
			// Print the bottom row
			for (int j = right; j >= left; --j)
				System.out.print(matrix.get(down).get(j) + " ");
			down--;
			if (top > down || left > right)
				break;
			// Print the leftmost column
			for (int i = down; i >= top; --i)
				System.out.print(matrix.get(i).get(left) + " ");
			left++;
			if (top > down || left > right)
				break;
		}
	}

	public static void main(String args[]) throws FileNotFoundException {

		ArrayList<ArrayList<String>> secondDArray = new ArrayList<ArrayList<String>>();

		// Taking input into a 2D arraylist from text file
		File file = new File(
				"C:/Users/Sourajit/workspace/FunnyExamples/src/spiralOrderPrint2DArray/textFileInput");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String newLine = scanner.nextLine();
			// newLine = newLine.replaceAll(" ", "");
			Scanner lineScanner = new Scanner(newLine);
			ArrayList<String> lineArray = new ArrayList<String>();

			while (lineScanner.hasNext()) {
				lineArray.add(lineScanner.next());
			}

			secondDArray.add(lineArray);
		}
       
		//Calling static function to print in spiral format
		spiralOrder(secondDArray);

	}
}
