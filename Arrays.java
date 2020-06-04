package nyu.edu.cs.cs102.ask662.crs;
import java.util.*;
//import java.util.array;



public class Arrays {
	
	public static void main(String[] args) {
		String string1 ="google";
		String string2 = "elgoog";
		System.out.println(compareStrings(string1,string2));
		String string3 = "Long, time, ago, in, a, galaxy, far, far, away";
		System.out.println(returnString(string3));
		int [] arrayMax = {4, 5, 8, 12, 7, 3, 2};
		System.out.println(findMax(arrayMax, 0, 6));
		int n = 3;
		System.out.println(findZero(n));
		String string4 = "hannah";
		System.out.println(isPalindrome(string4));
		int[] array = {4, 77, 98, 30, 20, 50, 77, 22, 49, 2};
		System.out.println(java.util.Arrays.toString(bubbleSort(array)));
		System.out.println(java.util.Arrays.toString(bubbleSortRecursive(array,9)));
		System.out.println(java.util.Arrays.toString(selectionSort(array)));
		System.out.println(java.util.Arrays.toString(insertionSort(array)));
		int [] array4 = new int[10];
		mergeSort(array, array4, 0, 9);
		System.out.print("["+ array[0] + ", ");
		for (int i= 1; i < array.length-1; i++) {
			System.out.print(array[i]+", ");
		}
		System.out.print(array[array.length-1]+ "]");
		System.out.print("\n");
		//System.out.println(java.util.Arrays.toString(mergeSort(array, array4, 0, 9)));
		System.out.println(java.util.Arrays.toString(quickSort(array, 0, 9)));
		/**int size = array.length;
		int[] sortArray = int [size];
		sortArray = selectionSort(array);**/
		
		
		
		
		
		
		
		
		
	}

	//https://www.geeksforgeeks.org/reverse-a-string-in-java-5-different-ways/
	public static int compareStrings(String string1, String string2) {
		string1 = string1.toLowerCase().trim();
		//ignore white space and case
		string2 = string2.toLowerCase().trim();
		boolean flag = true;
		//set flag to true
		//if length of first string doesnt equal second, then not equal automatically
		if (string1.length() != string2.length()) {
			flag = false;
		}
		//match each index with opposite index
		for (int i = string1.length() -1; i > -1; i--) {
           if (string2.charAt(i) != string1.charAt(string1.length()-1-i)) {
        	   flag = false;
        	   //if not equal then automatically false
           }
        }
        if (flag){
        	return 1;
        }
        else {
        	return 0;
        }
		
	}
	
	
	public static String returnString(String string3) {
		String myString = "";
		//create empty string
		String[] smallerStrings = string3.split(",");
		for (int i=0; i< smallerStrings.length; i = i+3) {
			String min = "";
			// minimum in each block of 3
			if ((smallerStrings[i].length() <= smallerStrings[i+1].length()) && (smallerStrings[i].length() <= smallerStrings[i+2].length())) {
				min = smallerStrings[i];
			}
			else if ((smallerStrings[i+1].length() <= smallerStrings[i].length()) && (smallerStrings[i+1].length() <= smallerStrings[i+2].length())) {
				min = smallerStrings[i+1];
			}
			else if ((smallerStrings[i+2].length() <= smallerStrings[i+1].length()) && (smallerStrings[i+2].length() <= smallerStrings[i].length())) {
				min = smallerStrings[i+2];
			}
			myString += min;
		}//add to empty string
		return myString;
	}
	//chapter 3, slide 21
	public static int findMax(int [] array, int begin, int end) {
		if (begin == end) {
			return array[begin];
			//base case if array is size 1
		}
		//now we have to split the array and recursively find the maximum in each half of the array
		int middle = (begin + end)/2;
		int max1 = findMax(array, begin, middle);
		int max2 = findMax(array, middle +1, end);
		if (max1 >= max2) {
			return max1;
		}
		else {
			return max2;
		}
	}
	
	//finding how many 0's in an integer
	public static int findZero(int n) {
		if (n == 0) {
			return 0;
		}
		if (n % 2 == 1) {
			return 0 + findZero(n/2); 
			
		}
		else {
			return 1 + findZero(n/2); 
		}
	}
		
		public static boolean isPalindrome(String string4) {
			if ((string4.length() == 0)) {
				return true;
				//base case
			}
			else if (string4.charAt(0) == string4.charAt(string4.length()-1))  {
				return isPalindrome(string4.substring(1, string4.length()-1));
				//separate into substrings
			}
			else {
				return false;
			}
		}
		
		//Chapter 5, Slide 138
		// best case O(n) worst case O(n^2)
		/**public static int[] bubbleSort(int array[]) {
			for (int i = 0; i < array.length -1; i++) {
				 for (int j = 0; j < array.length - (i+1); j++){
					 if (array[j] > array[j+1]) {
						 int current = array[i];
						 array[i] = array[i+1];
						 array[i+1] = current;
					 }
					 else {//if second element is larger than first
						 i++;
				}
			}
		}
			return array;
		}**/
		//Chapter 5, Slide 138
		public static int[] bubbleSort(int array[]){
			for (int i = 0; i < array.length -1; i++) {
				 for (int j = 0; j < array.length - (i+1); j++){
					 //compare each index with the one in front
					if (array[j] > array[j+1]){ //if int is greater than the index higher
						int current = array[j];
						array[j] = array[j+1];
						array[j+1] = current;
						//swapped!!
		}
		}
		}
			return array;
			//so we are able to print
		}

		
		//https://www.geeksforgeeks.org/recursive-bubble-sort/
			 public static int[] bubbleSortRecursive(int array[], int n){
				 if (n==1) {
					 return array;
					 //base case, we are done sorting
				 }
				 for (int i=0; i < array.length -1; i++) {
						if (array[i] > array[i+1]) {
							 int current = array[i];
							 array[i] = array[i+1];
							 array[i+1] = current;
							 //same swap method
						 }
			        bubbleSortRecursive(array, n-1);
			        //recursive call on next int
					 }
				 return array;
				}
			
			 

			 
		
		//Chapter 5, slide 50
		/**public static int[] selectionSort(int array[]){
			for (int i = 0; i < array.length; i++) {
				int min = i;
				for (int j = 0; j < array.length; j++) {
					if (array[i] > array[min]) {
						min = j;
					}
				}
				int current = array[min];
				array[min] = array[i];
				array[i] = current;			
			}
			return array;
		}**/
			//Chapter 5, slide 50
		public static int[] selectionSort(int array[]){
		int current;
		int min;
		for (int i = 0; i < array.length; i++){
			min = i;//set current min to i
			for (int j = i + 1; j < array.length; j++){
				if (array[j] < array[min]) {
					min = j;
					//if greater index is less than current min, then change the min to j
				}
			current = array[min];
			array[min] = array[i];
			array[i] = current;
			//swap method!!!
			}
		}
		return array;
		}

		
		
		
		
		
		//Chapter 5, slide 65
		//Time complexity of the Insertion Sort algorithm is O(n^2)
		/**public static int[] insertionSort(int array[]){
			for (int i = 1; i < array.length; i++){
				int j = i-1;
				int current = array[i];
				while (j > 0 && array[j] > current){
					array[j] = array[j - 1];
					j--;
				 }
				array[j] = current;
			}
			return array;
		}**/
		//Chapter 5, slide 65
		public static int[] insertionSort(int array[]){
			int current;
			//only sorted is first elem so far
			for (int i = 1; i < array.length ; i++){
				int j = i;
				//loop through elements
				current = array[i];
				while (j > 0 && current < array[j - 1]){
					//moving rightward through the array
					array[j] = array[j - 1];// right shifting
					j--;
				}
				array[j] = current;
				//this becomes the current elem or part of the sorted, before we continue the algorithm
			}
			return array;
			}
		
		//Chapter 5, slide 73-74
		/**public static void merge(int [ ] array_1, int left1, int right1, int[ ] array_2, int left2, int right2, int [] array_3, int left) { // to X[left…]
				int i1 = left1; 
				int i2=left2; 
				int i= left; // heads of X1, X2, X.
				while (i1 <= right1 && i2 <= right2) {
					if (array_1[i1] <= array_2[i2]) {
						array_3[i]=array_1[i1];
						i1++;
						i++;
					}
					else {
						array_3[i]=array_2[i2];
						i2++;
						i++;
					}
					if (i1<right1) { // copy leftovers of X1 to the end of X
						while (i1<= right1) {
							array_3[i]=array_1[i1]; i1++; i++;
						}
					}
					if (i2<right2) {// copy leftovers of X2 to the end of X
						while (i2<= right2) {
							array_3[i]=array_2[i2]; 
							i2++; 
							i++;
						}
					}
				}
		}**/
		//Chapter 5, slide 73-74
		public static void merge(int [ ] array_1, int l1, int r1, int [ ] array_2, int l2, int r2, int [] array_3, int l) { 
				int i1 = l1; 
				int i2= l2; 
				int i= l; // heads of X1, X2, X.
				//left most of the 3 arrays
				while (i1 <= r1 && i2 <= r2)
					//while they are greater than right most extreme
				if (array_1[i1] <= array_2[i2]) {
					array_3[i]=array_1[i1];
					//if array 1 elem is greater/= second array first elem, continue looping
					i1++;
					i++;
				}
				else {
					array_3[i]= array_2[i2];
					//if it isnt, then add the left most point of array2 instead od array1 to array3
					i2++;
					i++;
				}
				if (i1<r1) {// copy leftovers of X1 to the end of X
					while (i1<= r1) {
						array_3[i]=array_1[i1];
						i1++; 
						i++;
					}
					//if left is less than right, while it is, copy the rest of array2 into array3, continue looping
				}
				if (i2<r2) { // copy leftovers of X2 to the end of X
					while (i2<= r2) {
						array_3[i]=array_2[i2]; 
						i2++; 
						i++;}
					}
				}
		
		//Chapter 5, slide 73-74
				/**public static int[] mergeSort(int [] array1, int [] array2, int begin, int end) {
					if (begin== end) {
						array2[begin] = array1[begin]; 
						return array2;
					}
					else {
					int middle = (begin + end)/2;
					int [] Z = new int[end+1];
						// next, sort left half of X and put the result in left half of Z
						mergeSort(array1, array2, begin, middle);
						// next, sort right half of X and put the result in right half of Z
						mergeSort(array1, array2, middle +1, end);
						// next, merge the two halves of Z and put result in Y
						merge(Z,begin,middle, Z,middle +1,end, array2,begin);
					}
					return array2;
					}**/
				
		
		/** Result is            B[ iBegin:iEnd-1   ].
		public void merge(double[] array1, int begin, int middle, int end){
		    i = iBegin, j = iMiddle;
		 
		    // While there are elements in the left or right runs...
		    for (k = iBegin; k < iEnd; k++) {
		        // If left run head exists and is <= existing right run head.
		        if (i < iMiddle && (j >= iEnd || A[i] <= A[j])) {
		            B[k] = A[i];
		            i = i + 1;
		        } else {
		            B[k] = A[j];
		            j = j + 1;
		        }
		    }
		}

		CopyArray(A[], iBegin, iEnd, B[])
		{
		    for(k = iBegin; k < iEnd; k++)
		        B[k] = A[k];
		}
		public void merge(double [] array1, int begin, int middle, int end) {
		  int midPlus=middle+1;

		    while(high <= middle ){
		    
		        if(array1[high]<=array2[midPlus]){
		            array2[low]=array2[low];
		            low++;
		        }
		        else{
		            array2[low]=array1[midPlus];
		            midPlus++;
		        }
		        low++;
		    }
		    if(high > middle)
		    {
		        for(k=j; k<=high; k++)
		        {
		            b[i]=a[k];
		            i++;
		        }
		    }
		    else
		    {
		        for(k=h; k<=pivot; k++)
		        {
		            b[i]=a[k];
		            i++;
		        }
		    }
		    for(k=low; k<=high; k++) a[k]=b[k];
		}**/

		//Chapter 5, slide 73-74
		public static void mergeSort(int [ ] array1, int [ ] array2, int begin, int end){
			if (begin==end) {
				array2[begin] = array1[begin];
				return;
			}
			//if beginning of array1 and 2 are equal, then return
			int middle = (begin+end)/2;
			int [] Z = new int[end+1]; //create array z, size is end+1
			// next,sort first part of array1 and put in z
			mergeSort(array1,Z,begin,middle);
			// next, sort second part of array2 and put in z
			mergeSort(array1,Z,middle+1,end);
			// call merge, combine into array2
			merge(Z,begin,middle, Z,middle+1,end, array2,begin);
			
			
			}
		//https://www.geeksforgeeks.org/quick-sort/
		public static int part(int array[], int l, int r){
	        int middle = array[r]; 
	        int i = (l-1); 
	        for (int j=l; j<r; j++)
	        {
	            if (array[j] <= middle)
	            {
	                i++;
	                int current = array[i];
	                array[i] = array[j];
	                array[j] = current;
	                //swap method!!
	            }
	        }
	        int current = array[i+1];
	        array[i+1] = array[r];
	        array[r] = current;
	 //swap method
	        //so basically, we want to have one number as the pivot and recusively sort either side of the pivot so that smaller and bigger on either side
	        //when they cross over, the array has been sorted
	        return i+1;
	    }
		 /**public void quickSort()
		while i < j
		if smaller, do nothing, incremenent i
		i++
		while a[i] < pivot
		then break out of while loop
		while j > pivot,
		decrease
		breaks when you find something smaller
		if i is still smaller than j, swap
		if i is now greater than j, we found index of pivot
		move i until greater than pivot
		move j until smaller than pivot
		swap pivot with innermost index
		low= low
		high = i-1
		
		low = i +1
		high =  high**/
		//https://www.geeksforgeeks.org/quick-sort/
	    public static int[] quickSort(int array[], int l, int r){
	        if (l < r){
	            int mid = part(array, l, r);
	            quickSort(array, l, mid-1);
	            quickSort(array, mid+1, r);
	        }
	        return array;
	    }
	 //recursively sort array, done when crossover
	   
		
		
	
	 
				
				
			
		
			
				
			
			
			
		
		
		
		
	}
		
