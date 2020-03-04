package hard;

public class FindMissingPositive {

	public static void main(String[] args) {
		int a[] = { -1, -2, 0, 2, 1, 3 };
		int x = findPositiveSegragate(a);
		System.out.println(x);
		int y = findPositiveSwap(a);
		System.out.println("\n" + y);

	}

	private static int findMissing(int[] a) {
		int n = a.length;

		for (int i = 0; i < n; i++) {
			int x = Math.abs(a[i]);// x to be used as index
			System.out.println("i a[i] " + i + " " + a[i]);
			if (x - 1 < n && a[x - 1] > 0) {// a[a[i]-1] since index starts from 0 and num frm 1, we wnt to visit 0 as
											// well and
											// use element at 0 too.
				a[x - 1] = -a[x - 1];
			}

		}
		for (int i = 0; i < n; i++) {
			if (a[i] > 0)
				return i + 1; // 1 is added because 0 will be missing but we dont want to report 0 as its
								// already separated
		}
		return n + 1;

	}

	private static int findPositiveSegragate(int[] a) {
		int n = a.length;
		int shift = segragate(a);
		int[] arr = new int[n - shift];
		int j = 0;
		for (int i = shift; i < n; i++) {
			arr[j++] = a[i];
		}
		return findMissing(arr);
	}

	private static int segragate(int[] a) {
		int n = a.length;
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] <= 0) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				j++;
			}
		}
		return j;
	}

	// i=a[i], a[i] = a[a[i]] since we want to start from 1 so a[i]=a[a[i+1]]
	private static int findPositiveSwap(int A[]) {
//		int n = a.length;
//		for(int i=0; i< n ;i++) {
//			while(a[i]!=i+1) {
//				if(a[i]<=0 || a[i]>=n) {
//					break;//-ve, 0 and out of range ignored
//				}
//				if(a[i] == a[a[i]-1]) {
//					break;// duplicates ignored
//				}
//				int temp = a[i];
//				a[i] = a[temp-1];//ignoring 0 but not 0th element so offset of -1
//				a[temp-1]=temp;
//			}
//		}
//		for(int i=0; i< n ;i++) {
//			System.out.print(" "+a[i]);
//		}
//		for(int i=0; i< n ;i++) {
//			if(a[i]!=i+1) {
//				return i+1;// 0 maybe found but ignore 0 so adding 1
//			}
//		}
//		return n+1;
//	}
		int n = A.length;

		for (int i = 0; i < n; i++) {
			
			while (A[i] != i + 1) {
				if (A[i] <= 0 || A[i] >= n)
					break;

				if (A[i] == A[A[i] - 1])//if there are duplicates
					break;

				int temp = A[i];
				A[i] = A[temp - 1];//swap one place. move +ves to beg of array so temp -1
				A[temp - 1] = temp;
				//System.out.print(" " + A[i]);
			}
			
			System.out.print(" " + A[i]);
		}
		System.out.println("\n");
		for (int i = 0; i < n; i++) {
			System.out.print(" " + A[i]);
		}
		for (int i = 0; i < n; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}

		return n + 1;
	}

}
