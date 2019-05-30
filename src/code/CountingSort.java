package code;

import given.AbstractArraySort;

/*
 * Implement the c algorithm here. You can look at the slides for the pseudo-codes.
 * You do not have to use swap or compare from the AbstractArraySort here
 * 
 * You may need to cast any K to Integer
 * 
 */

public class CountingSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	//Add any fields here

	public CountingSort()
	{
		name = "Countingsort";
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort(K[] inputArray) {

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

		if(!(inputArray[0] instanceof Integer)) {
			System.out.println("Can only sort integers!");
			return;
		}

		//TODO:: Implement the counting-sort algorithm here
		
		int hi = (int) inputArray[0];
		int lo = (int) inputArray[0];
		for(K key : inputArray) {
			if((int) key > hi) hi = (int) key;
			if((int) key < lo) lo = (int) key;
		}
		int k = hi - lo + 1;
		int[] counts = new int[k];
		
		for(int i = 0; i < inputArray.length; i++) {
			counts[(int) inputArray[i] - lo]++;
		}

		int c = 0;
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < counts[i]; j++) {
				
				inputArray[c] = (K) (Integer) (i + lo);
				c++;
			}
		}

	}

}
