package hard;

public class RainWaterTrapping {

	public static void main(String[] args) {
		int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		RainWaterTrapping rt = new RainWaterTrapping();
		System.out.println("Water trapped is "+rt.trapWaterDP(arr));
		System.out.println("Water trapped is "+rt.trapWater(arr));

	}
	//O(n) O(n) two iterations
	private int trapWaterDP(int[] arr) {
		int n = arr.length;
		int[] left_max = new int[n];
		int[] rt_max = new int[n];
		int ans = 0;
		left_max[0]= arr[0];
		
		for (int i=1; i< n; i++) {
			left_max[i] =  Math.max(arr[i], left_max[i-1]);
		}
		rt_max[n-1] = arr[n-1];
		for(int i= n-2; i >= 0; i--) {
			rt_max[i] = Math.max(arr[i], rt_max[i+1]);
		}
		for(int i = 0; i < n; i++) {
			ans+= Math.min(left_max[i],rt_max[i])-arr[i];
		}
		return ans;	
	}
	// O(n) O(1)
	private int trapWater(int[] arr) {
		int n = arr.length;
		int l = 0;
		int h = n-1;
		int left_max = arr[0];
		int rt_max = arr[n-1];
		int ans = 0;
		
		while (l < h) {
			if(arr[l] < arr[h]) {
				if(arr[l] > left_max) {
					left_max = arr[l];
				} else {
					ans = ans + (left_max - arr[l]);
				}
				l++;
			} else {
				if(arr[h] > rt_max) {
					rt_max = arr[h];
				} else {
					ans = ans + (rt_max - arr[h]);
				}
				h--;
			}
		}
		return ans;
	}

}
