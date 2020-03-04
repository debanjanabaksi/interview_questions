package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. 
There is no restriction on how your encode/decode algorithm should work. 
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */

public class CreateTinyUrlBasicSolutions {

	Map<String, String> shortUrlMap = new HashMap<String, String>();
	Map<String, String> longUrlMap =  new HashMap<String, String>();
	
	public static void main(String[] args) {
		CreateTinyUrlBasicSolutions tinyUrl = new CreateTinyUrlBasicSolutions();
		String longUrl = "https://leetcode.com/problems/design-tinyurl";
		String shortUrl = tinyUrl.generateIndependentBase62Url(longUrl);
		System.out.println("Short url is : "+ shortUrl);
		System.out.println("Long url is : "+ tinyUrl.decodeUrl(shortUrl));

	}
	
	private  String generateIndependentBase62Url(String longUrl) {
		//length of tiny url extension is 6
		//can append http://tinyurl.com/ to it
		String prefix = "http://tinyurl.com/";
		if (longUrlMap.containsKey(longUrl)) {
			return longUrlMap.get(longUrl);
		}
		String shortUrlSuffix = randomUrlGenerator();
		String shortUrl = prefix+shortUrlSuffix;
		while (shortUrlMap.containsKey(shortUrl)) {
			shortUrl = prefix +randomUrlGenerator();
		} 

		shortUrlMap.put(shortUrl, longUrl);
		longUrlMap.put(longUrl, shortUrl);
		
		return shortUrl;
	}
	
	private String decodeUrl(String shortUrl) {
		return shortUrlMap.get(shortUrl);
	}
	
	private  String randomUrlGenerator() {
		Random random = new Random();
		StringBuilder shortUrl = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			int num = random.nextInt(62); // 62 since we hv 10 digits a-z and A-Z
			if(num < 10) {
				shortUrl.append(num);
			} else if( num < 36) {
				shortUrl.append((char)(num-10 +'a'));
			} else if (num < 62) {
				shortUrl.append((char)(num-36 +'A'));
			}
		}
		return shortUrl.toString();
	}

	
}
