public class BasicExercises8 {
	    // Returns index of x if it is present in arr[], 
	    // else return -1 
	    int binarySearch(int arr[], int x) { 
	        int l = 0, r = arr.length - 1; 
	        while (l <= r) { 
	            int m = l + (r - l) / 2; //T(n) = T(n/2) + c 	  
	            // Check if x is present at mid 
	            if (arr[m] == x) 
	                return m; 
	            // If x greater, ignore left half 
	            if (arr[m] < x) 
	                l = m + 1;  
	            // If x is smaller, ignore right half 
	            else
	                r = m - 1; 
	        } 
  
	        // if we reach here, then element was 
	        // not present 
	        return -1; 
	    } 
	  
	    // Driver method to test above 
	    public static void main(String args[]) 
	    { 
	    	BasicExercises8 ob = new BasicExercises8(); 
	        int arr[] = {2,9,37,44,51,58,67,79}; 
	        int n = arr.length; 
	        int x = 2; 
	        int result = ob.binarySearch(arr, x); 
	        if (result == -1) 
	            System.out.println("out of data"); 
	        else
	            System.out.println("position " + result); 
	    } 
	} 