package medium;

public class MedianOfSrotedArrays {

	public static void main(String[] args) {
		int ar1[] = {1, 12, 15, 26, 38}; 
        int ar2[] = {2, 13, 17, 30, 45}; 
       
        int n1 = ar1.length; 
        int n2 = ar2.length; 
        if (n1 == n2) 
            System.out.println("Median is " + 
            		getMedianSimple(ar1, ar2)); 
        else
            System.out.println("arrays are of unequal size"); 
        
        System.out.println("\n\n\n");
        
        int arr1[] = {1, 2, 3, 6};  
        int arr2[] = {4, 6, 8, 10};  
       int nn1 = ar1.length;  
       int nn2 = ar2.length;  
       if (nn1 == nn2)  
            System.out.println("Median is " + getMedianOptimized(arr1, arr2));  
        else
           System.out.println("Doesn't work for arrays "+ "of unequal size");  
       
	}
	
	static int getMedianSimple(int[] a1, int[] a2) {
		int i=0;
		int j=0;
		int n = a1.length;
		int m1=-1; int m2=-1;
		
		//array size is 2n so median is avg of n and n+1
		
		for(int count = 0; count <= n; count++) {
			//If all of a1 is < 1st el of a2
			if(i ==  n) {
				System.out.println(" i == n Current m1 "+m1);
				m1 = m2;
				m2 = a2[0];
				System.out.println("Current m2 "+m2);
			}
			System.out.println();
			if(j == n) {
				System.out.println("j ==n Current m1 "+m1);
				m1 = m2;
				m2 = a1[0];
				System.out.println("Current m2 "+m2);
			}
			System.out.println();
			if(a1[i] < a2[j]) {
				System.out.println("a1[i] < a2[j] Current m1 "+m1+" "+a1[i]+" "+a2[j]);
				// saving prev value
				m1 = m2;
				m2 = a1[i];
				System.out.println("Current m2 "+m2);
				i++;
			} else {
				System.out.println("\n a1[i] > a2[j] Current m1 "+m1+" "+a1[i]+" "+a2[j]);
				m1 = m2;
				m2 = a2[j];
				System.out.println("Current m2 "+m2);
				j++;
			}
			
		}
		System.out.println("");
		System.out.println("Current m1 "+m1);
		System.out.println("Current m2 "+m2);
		System.out.println("");
		return (m1+m2)/2;
	}
	
	static int getMedianOptimized(int[] a1, int[] a2) {
		int n = a1.length;
		int m1=-1;
		int m2=-1;
		 if (n==0) {
			 System.out.println("n is 0");
			 return 0;
		 }
		 if(n==1) {
			 System.out.println("n is 1 median is "+ (a1[0]+a2[0])/2);
			 return (a1[0]+a2[0])/2;
		 }
		 if(n==2) {
			 System.out.println("n is 2 median is "+ (Math.max(a1[0],a2[0])+Math.min(a1[1],a2[1]))/2);
			return (Math.max(a1[0],a2[0])+Math.min(a1[1],a2[1]))/2;
		 }
		 
		m1 = getMedian(a1);
		m2 = getMedian(a2);
		System.out.println();
		System.out.println("Current m1 "+m1);
		System.out.println("Current m2 "+m2);
		System.out.println();
		
		if(m1==m2) {
			 System.out.println("m1 = m2"+ m1);
			return m1;
		}
		
		if(m1 < m2) {
			System.out.println("m1 < m2 "+m1 + " "+m2);
			int count;
			int arLength = 0;
			
			if(n%2 ==  0) {
				count = n/2 -1;
				arLength = n - n/2 +1;
				
			} else {
				count = n/2;
				arLength = n - n/2;
			}
			
			int arr[] = new int [arLength];
			int j = 0;
			
			for(int i = count; i < n; i++) {
				arr[j++] = a1[i];
			}
			return getMedianOptimized(arr, a2);
			
		}  else {
			System.out.println("m1 > m2 "+m1 + " "+m2);
			int count;
			int arLength = 0;
			if(n%2 ==  0) {
				count = n/2 -1;
				arLength = n - n/2 +1;
				
			} else {
				count = n/2;
				arLength = n - n/2;
			}
			int arr[] = new int [arLength];
			int j = 0;
			
			for(int i = count; i<n; i++) {
				arr[j++] = a2[i];
			}
			return getMedianOptimized(a1, arr);
		}
		
		
	}
	
	static int getMedian(int[] arr) {
		int n = arr.length;
		if(n%2 ==  0) {
			return (arr[n/2]+arr[n/2 - 1])/2;
		}
		return arr[n/2];
	}

}
