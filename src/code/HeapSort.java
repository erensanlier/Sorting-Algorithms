package code;

import given.AbstractArraySort;

/*
 * Implement the heap-sort algorithm here. You can look at the slides for the pseudo-code.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 */

public class HeapSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	// Add any fields here

	public HeapSort() {
		name = "Heapsort";

		// Initialize anything else here
	}

	@Override
	public void sort(K[] inputArray) {
		// TODO: Implement the heap-sort algorithm

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
		
		heapify(inputArray);
		int i = inputArray.length - 1;
		
		while(0 < i) {
			swap(inputArray, 0 , i);
			i--;
			downheap(inputArray, 0 , i);
		}
	}

	// Public since we are going to check its output!
	public void heapify(K[] inputArray) {
		// TODO: Heapify the array. See the slides for an O(n) version which uses
		// downheap
		for(int i = inputArray.length / 2; i >= 0; i--) {
			downheap(inputArray, i, inputArray.length - 1);
		}

	}

	// The below methods are given given as suggestion. You do not need to use them.
	// Feel free to add more methods

	protected void downheap(K[] inputArray, int i, int j) {
		
		int index = i;
		int lc = 2 * index + 1;
		int rc = 2 * index + 2;
		if(lc <= j && compare(inputArray[index], inputArray[lc]) < 0)
			index = lc;
		if(rc <= j && compare(inputArray[index], inputArray[rc]) < 0)
			index = rc;
		if(index != i) {
			swap(inputArray, i, index);
			downheap(inputArray, index, j);
		}

	}
	
}
