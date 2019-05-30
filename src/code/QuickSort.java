package code;

import given.AbstractArraySort;

/*
 * Implement the quick-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 */

public class QuickSort<K extends Comparable<K>> extends AbstractArraySort<K> {  
	//Add any fields here

	public QuickSort()
	{
		name = "Quicksort";

		//Initialize anything else here
	}

	//useful if we want to return a pair of indices from the partition function.
	//You do not need to use this if you are just returning and integer from the partition
	public class indexPair {
		public int p1, p2;

		indexPair(int pos1, int pos2)
		{
			p1 = pos1;
			p2 = pos2;
		}

		public String toString()
		{
			return "(" + Integer.toString(p1) + ", " + Integer.toString(p2) + ")";
		}
	}


	@Override
	public void sort(K[] inputArray)
	{
		//TODO:: Implement the quicksort algorithm here

		quicksort(inputArray, 0, inputArray.length - 1);
	}

	// Public since we are going to check its output!
	public indexPair partition(K[] inputArray, int lo, int hi, int p)
	{
		//TODO:: Implement a partitioning function here

		swap(inputArray, p, hi); // pivot to hi
		int i = lo;
		int j = hi - 1;
		while(i <= j) {
			while(i <= j && compare(inputArray[i], inputArray[hi]) < 0){
				i++;
			}
			while(i <= j && compare(inputArray[j], inputArray[hi]) > 0) {
				j--;
			}
			if(i <= j) {
				swap(inputArray, i, j); 
				i++; 
				j--;
			}
		}
		swap(inputArray, hi, i);

		return new indexPair(i - 1, i + 1); //pivot minus 1 and pivot plus 1
	}

	/* Alternative, if you are just returning an integer
  public int partition(K[] inputArray, int lo, int hi, int p)
  {
    //TODO:: Implement a partitioning function here
    return null;
  }*/

	//The below methods are given given as suggestion. You do not need to use them.
	// Feel free to add more methods  


	int randomWithRange(int min, int max)
	{
		if(min == max) return min;
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
	
	protected int pickPivot(K[] inputArray, int lo, int hi)
	{
		//TODO: Pick a pivot selection method and implement it
		
//		int r1 = randomWithRange(lo, hi);
//		int r2 = randomWithRange(lo, hi);
//		int r3 = randomWithRange(lo, hi);
//
//		if (inputArray[r1].compareTo(inputArray[r2]) > 0) {
//			if (inputArray[r2].compareTo(inputArray[r3]) > 0) {
//				return r2;
//			} else if (inputArray[r1].compareTo(inputArray[r3]) > 0) {
//				return r3;
//			} else {
//				return r1;
//			}
//		} else {
//			if (inputArray[r1].compareTo(inputArray[r3]) > 0) {
//				return r1;
//			} else if (inputArray[r2].compareTo(inputArray[r3]) > 0) {
//				return r3;
//			} else {
//				return r2;
//			}
//		}
		
		return randomWithRange(lo, hi);
		
//		return (lo + hi) / 2;
		
	}

	private void quicksort(K[] inputArray, int lo, int hi) {
		if(lo < hi) {
			int pivot = pickPivot(inputArray, lo, hi);
			indexPair pair = partition(inputArray, lo, hi, pivot);
			quicksort(inputArray, lo, pair.p1);
			quicksort(inputArray, pair.p2, hi);
		}
	}
}
