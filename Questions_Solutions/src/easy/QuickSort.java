package easy;

public class QuickSort {

	public static void main(String[] args) {
		int num[] = {9, 2, 4, 7, 3, 7, 10};
		quickSort(num, 0, num.length-1);
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		System.out.println("low and high "+ low+" "+high);
		if(high>low) {
			System.out.println("starting sort");
			int pos = partition(arr, low, high);
			quickSort(arr, low, pos-1);
			quickSort(arr, pos+1, high);
		}
	}
	
	private static int partition(int[]arr, int low, int high) {
		int num = arr[low];
		int x = low;
		int y = high+1;
		System.out.println("Inside partition method x and y "+ x+" "+y);
		while (y>x) {
			System.out.println("x and y "+ x+" "+y);
			while(arr[++x]<num);
			while(arr[--y]>num);
			System.out.println(arr[x]+" "+ arr[y]);
			if(y>x) {
				System.out.println("swapping "+arr[x]+" "+ arr[y]);
				int temp = arr[x];
				arr[x] = arr[y];
				arr[y]= temp;
			}
		}
		System.out.println("while over "+arr[low]+" "+ arr[y]);
		int temp = arr[y];
		arr[y] = arr[low];
		arr[low] = temp;
		return y;
	}

}
