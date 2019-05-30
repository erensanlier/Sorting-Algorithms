package code;

import java.util.Arrays;

import given.AbstractArraySort;

/*
 * Your sorting algorithm for the sorting spree! 
 * You do not need to use the swap and compare methods of AbstractArraySort here
 * Only the speed of the code and the correctness of the output will be checked
 * 
 * We suggest that you use a hybrid algorithm!
 * 
 */

public class ContestEntrySort<K extends Comparable<K>> extends AbstractArraySort<K> {

	public ContestEntrySort() {
		// Change the name with your ID!
		name = "60326";

		//Initialize anything else here
	}

	@Override
	public void sort(K[] inputArray) {
		// TODO: Implement your contest entry here. 

		// If random three arguments are same, use timsort

		// IF ladder, sorted or constant use timsort else counting sort (COULDN'T IMPLEMENT TIMSORT)

		if(inputArray == null)
		{
			System.out.println("Null array");
			return;
		}
		if(inputArray.length < 1)
		{
			System.out.println("Empty array");
			return;
		}   

		boolean constant = true;

		CountingSort<K> counting = new CountingSort<>();

//		for(int i = 0; i < 3; i++) {
//			if((Integer) inputArray[i * inputArray.length / 3] > (Integer) inputArray[(i + 1) * inputArray.length / 3 - 1]) {
//				constant = false;
//			}
//		}

		if(inputArray[0] instanceof Integer) { // constant sorted ladder da girme
			counting.sort(inputArray);
		}else {
			MergeSort<K> mergeSort = new MergeSort<>();
			mergeSort.sort(inputArray);
			
		}

		//TODO:: Implement the counting-sort algorithm here


	}
	
}
