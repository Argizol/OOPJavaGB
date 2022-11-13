package OOPJavaGB;

import java.util.Arrays;
import java.util.Comparator;

public class Lesson3Task1 {


	public static Integer[] MySort(int[] arr) {
		Integer[] result = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		Arrays.sort(result, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
			  return Integer.compare(o1 % 10,o2 % 10);
			}
		});
		return result;
	}

	public static void PrintResult(Integer[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString());
		}
	}
}
