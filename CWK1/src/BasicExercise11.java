import java.util.Arrays;
public class BasicExercise11 {
	static int compare = 0;
	static int swaps = 0;
	static int step = 0;
	public static void main(String[] args) {

		/*
		 * merge sort
		 * 
		 n	 		T(n) 
		 1 = 2^0 	0 
		 2 = 2^1 	2*T(1)+2 = 2 = 2*1 
		 4 = 2^2 	2*T(2)+4 = 8 = 4*2 
		 8 = 2^3 	2*T(4)+8 = 24 = 8*3 
		 16 = 2^4 	2*T(8)+16 = 64 = 16*4 
		 32 = 2^5 	2*T(16)+32 = 160 = 32*5 
		 n = 2^k 	2*T(n/2)+n = n*k
		 */

		/*
		 * bubble sort (n*(n-1))/2 n is array.length
		 */

		/*
		 * Selection sort 1/2(n^2-n) n is array.length
		 */

		int[] input = {7,3,4,8};
		int[] arr = {7,3,4,8};
		int[] array = {7,3,4,8};

		System.out.println("Merge sort: ");
		System.out.println("Numbers before sorting: ");
		for (int i = 0; i < array.length; i++) {

			System.out.print(array[i] + " ");

		}
		System.out.println();
		
		sort(array);
		
		System.out.println("compares: "+ compare);
		System.out.println("swaps: "+ swaps);		
		System.out.println(Arrays.toString(array));
		
		System.out.println("----------------------------");

		System.out.println("Bubble sort: ");
		System.out.println("Numbers before sorting: ");

		for (int i = 0; i < input.length; i++) {

			System.out.print(input[i] + " ");

		}

		bubbleSort(input);
		System.out.println(Arrays.toString(input));
		System.out.println("----------------------------");
		
		
		System.out.println("Selection sort: ");
		System.out.println("Numbers before sorting: ");
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");

		}
		System.out.println();

		SelectionSort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("----------------------------");
	}

	static void bubbleSort(int[] arr) {
		int numbers = arr.length;
		int temp = 0;
		int swap = 0;
		int count = 0;

		for (int i = 0; i < numbers; i++) {

			for (int j = 1; j < (numbers - i); j++) {
				count++;
				if (arr[j - 1] > arr[j]) {
					// swap elements

					System.out.println("step #" + step + ". swap " + arr[j - 1] + " and " + arr[j]);
					System.out.println(Arrays.toString(arr));
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					step++;
					swap++;
				}
			}
		}
		System.out.println("compare " + count); // compare : (n*(n-1))/2 n is array.length
		System.out.println("swap " + swap);
		
	}

	public static int[] SelectionSort(int[] arr) {
		int count = 0;
		int swap = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;

			for (int j = i + 1; j < arr.length; j++) {
				count++;
				if (arr[j] < arr[index]) {
					index = j;
					System.out.println("step #" + step + ". swap " + arr[i] + " and " + arr[j]);
					System.out.println(Arrays.toString(arr));
					int smallerNumber = arr[index];
					arr[index] = arr[i];
					arr[i] = smallerNumber;
					swap++;
					step++;
				}
			}
		}
		System.out.println("compare: " + count);
		System.out.println("swap: " + swap);
		return arr;
	}


	
	
	
	static void sort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
	}
	
	/** 
	 * merges sorted parts. Compare 2 parts and swap elements in necessary
	 * part A: from start to mid inclusive
	 * part B: from mid+1 to end
	 */
	static void mergeSort(int[] arr, int start, int end) {
		// 1 element, nothing to compare with
		if (end-start<=0) return; 
		
		// 2 elements, compare and swap if necessary
		compare++;
		if (end-start==1 && arr[end] < arr[start]) {
			swap(arr, start, end);
			
			return;
		} 
		
		//This is the hart of the Merge Sort
		// 3 and more elements require sort then merge
		
		// step 1. sort recursively each part.
		int mid = (start+end)/2;
		mergeSort(arr, start, mid);
		
		mergeSort(arr, mid+1, end);
		
		// step 2. merge sorted parts 
		merge(arr, start, mid, end);
		
	}
	
	/*
	 * merge 2 sorted parts. Compare and swap elements if necessary 
	 * part 1: from start to mid
	 * part 2: from mid+1 to end
	 * arr
	 * to initially the position where the first part starts
	 * mid half way between positions 'to' and 'end'
	 * end position where the second part ends
	 */
	static void merge(int[] arr, int to, int mid, int end) {
		int count = 0;
		int next = mid+1;
		while (to<=mid) {

			compare++;
			
			int from = next;
			while(next <= end && arr[to]>=arr[next]) {
				
				
				count++;
				next++;
				
			}
			
			if (count>0) {
				//move element from partB(right) to the partA(left). 
				
				swapAndShift(arr, to, from, count);
				// adjust positions accordingly

				to = to+count; 
				mid = mid+count;
				count = 0;
				
			}
			 
			if (next > end) {
				break;
			}
			to++;
			
		}	
		
	}
	
	/*
	 * 
	 * insertTo position where elements will be copied to
	 * insertFrom starting position where elements will be copied from
	 * count number of elements to be copied
	 * arr
	 */
	static void swapAndShift(int[] arr, int insertTo, int startFrom, int count) {
		
		int[] tmp = new int[count];
		// temporary save elements to be copied 
		System.arraycopy(arr, startFrom, tmp, 0, count);
		// shift elements in array to make space for copied elements
		System.arraycopy(arr, insertTo, arr, insertTo+count, startFrom-insertTo);
		// copy elements  
		System.arraycopy(tmp, 0, arr, insertTo, count);
		swaps++;
		step++;
		System.out.println("step #" + step + ". swap " +  arr[insertTo] + " and " + arr[startFrom]);
		System.out.println(Arrays.toString(arr));
		
	}

	static void swap(int[] arr, int i, int j) {
		int step = 0;
		int s = arr[i];
		arr[i] = arr[j];
		arr[j] = s;
		swaps++;
		System.out.println("step #" + step + ". swap " +  arr[j] + " and " + arr[i]);
		System.out.println(Arrays.toString(arr));
	}
	
	static void print (int[] arr) {
		for (int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}		
	}

	



}
