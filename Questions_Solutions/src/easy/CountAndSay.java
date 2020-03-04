package easy;

public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
		System.out.println(countAndSay(6));
		System.out.println(countAndSay(7));
		System.out.println(countAndSay(8));
		System.out.println(countAndSay(9));
		System.out.println(countAndSay(10));
		

	}
	
	private static String countAndSay(int n) {
		if (n<=0) {
			return null;
		}
		String result = "1";
		
		for (int i=1; i<n;i++) {
			int count = 1;
			StringBuilder sb = new StringBuilder();
			for (int j =1; j<result.length();j++) {
				if (result.charAt(j) == result.charAt(j-1)) {
					count++;
				} else {
					sb.append(count);
					sb.append(result.charAt(j-1));
					count =1;
				}
			}
			sb.append(count);
			sb.append(result.charAt(result.length()-1));
			result = sb.toString();
		}
		return result;
		
	}

}
