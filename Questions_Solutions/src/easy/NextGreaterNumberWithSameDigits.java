package easy;

import java.util.Arrays;

public class NextGreaterNumberWithSameDigits {

	public static void main(String[] args) {
		int[] digits = {5,3,4,9,7,6};
		findNext(digits);
		
	}

	private static void findNext(int[] a) {
		int n = a.length;
		int i;
		for (i = n - 1; i > 0; i--) {
			if (a[i] > a[i - 1]) {
				break;
			}
		}
		System.out.println("i is "+i);
		if (i == 0) {
			System.out.println("Not found");
			return;
		}
		int min = i;// we already know that a[i] > a[i-1] now need to find, elements > a[i-1] but smaller than a[i]. Infact the smallest.
		int x = a[i - 1];
		System.out.println("x is "+x+" min index is "+min);
		for (int j = i + 1; j < n; j++) {// so compare x with all elements after it to find min greater, since i is already > i-1, so start from i+1 and compare to i to find smallest
			System.out.println("j is "+j+" value at j is "+a[j]);
			if (a[j] > x && a[j] < a[min]) {
				System.out.println(" smaller found j is "+j+" value at j is "+a[j]);
				min = j;
			}
		}
		int temp = a[i - 1];
		a[i - 1] = a[min];
		a[min] = temp;

		Arrays.sort(a, i, n);

		System.out.print("Next number with same" + " set of digits is ");
		for (i = 0; i < n; i++)
			System.out.print(a[i]);
	}
}
