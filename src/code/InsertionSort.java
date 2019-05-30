package code;

import given.AbstractArraySort;

public class InsertionSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	public InsertionSort()
	{
		name = "Insertionsort";
	}

	@Override
	public void sort(K[] inputArray) 
	{   
		//TODO: Implement the insertion sort algorithm

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
		
		for(int i = 0; i < inputArray.length; i++) {
			int j = i;
			while(j > 0 && compare(inputArray[j - 1], inputArray[j]) > 0 ) {
				swap(inputArray, j, j - 1);
				j--;
			}
		}

	}

}
