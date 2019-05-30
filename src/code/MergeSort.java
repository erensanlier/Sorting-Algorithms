package code;

import given.AbstractArraySort;

/*
 * Implement the merge-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 * You may need to create an Array of K (Hint: the auxiliary array). 
 * Look at the previous assignments on how we did this!
 * 
 */

public class MergeSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	// Add any fields here
	K[] auxA;

	public MergeSort() {
		name = "Mergesort";

		// Initialize anything else here
	}

	@Override
	public void sort(K[] inputArray) {

		auxA = inputArray;
		mergesort(inputArray, 0, inputArray.length - 1);
	}

	// Public since we are going to check its output!
	public void merge(K[] inputArray, int lo, int mid, int hi) {

		int i = lo;
		int j = lo;
		int k = mid + 1;
		while(j <= hi) {
			if(k > hi || (i <= mid && compare(auxA[i], auxA[k]) <= 0)) {
				inputArray[j] = auxA[i];
				j++;
				i++;
			}else {
				inputArray[j] = auxA[k];
				j++;
				k++;
			}
		}

	}

	// Feel free to add more methods

	void mergesort(K[] inputArray, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;

			mergesort(inputArray, lo, mid);
			mergesort(inputArray, mid + 1, hi);

			merge(inputArray, lo, mid, hi);
		}
	}

}

//private static void mergeSort(Object[] src, Object[] dest, int low, int high, int off) {
//	
//	int length = high - low;
//
//	// Insertion sort on smallest arrays
//	if (length < INSERTIONSORT_THRESHOLD) {
//		for (int i=low; i<high; i++)
//			for (int j=i; j>low &&
//					((Comparable) dest[j-1]).compareTo(dest[j])>0; j--)
//				swap(dest, j, j-1);
//		return;
//	}
//
//	// Recursively sort halves of dest into src
//	int destLow  = low;
//	int destHigh = high;
//	low  += off;
//	high += off;
//	int mid = (low + high) >>> 1;
//			mergeSort(dest, src, low, mid, -off);
//			mergeSort(dest, src, mid, high, -off);
//
//			// If list is already sorted, just copy from src to dest.  This is an
//			// optimization that results in faster sorts for nearly ordered lists.
//			if (((Comparable)src[mid-1]).compareTo(src[mid]) <= 0) {
//				System.arraycopy(src, low, dest, destLow, length);
//				return;
//			}
//
//			// Merge sorted halves (now in src) into dest
//			for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
//				if (q >= high || p < mid && ((Comparable)src[p]).compareTo(src[q])<=0)
//					dest[i] = src[p++];
//				else
//					dest[i] = src[q++];
//			}
//}
