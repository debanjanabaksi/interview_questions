package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class PracticeJavaSyntax {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(2);
        al.add(6);
        al.add(9);
        al.add(4);
        al.add(20);
        
        System.out.println("Printing collection "+ al);
        List<Integer> ls = al.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
        
        System.out.println(
                "Printing the List after stream operation : "
                + ls);
        String str1 = "Doyel";
        String str2 = "Baksi";
        int[][]temp = new int[str1.length()][str2.length()]; //for string length is a method
        int n = temp[0].length; // for array, length is a variable
        int m = temp[1].length;
        
        Set<Integer> set = new HashSet<Integer>();
        for (int val : al) {
        	set.add(val);
        }
        for (int i = 0; i < al.size(); i++) { // collection size()
        	set.add(al.get(i));
        }
        List<String> list1 = Arrays.asList("Geeks", "for", 
                     "GeeksQuiz", "GeeksforGeeks", "GFG");
        List<String> list2 = new ArrayList<String>();
        list2.addAll(list2);
        Set<String> set2 = new HashSet<String>(list1);
        set2.addAll(list2);
        
        set2.add(str1);
        
        set2.size();
        boolean a = set2.contains("Doyel");
        boolean b = set.containsAll(al);
        
        set.remove(al.get(0));
        
        for(int nums : set) {
        	System.out.print(nums + " ");
        }
        System.out.println();
       // cant iterate over a set by index
        Iterator<String> itr = set2.iterator();
        while(itr.hasNext()) {
        	System.out.print(itr.next() + " ");
        }
        System.out.println();
        
        System.out.println(al);
        System.out.println(set2);
        Map<String, String> map1 = new HashMap<String, String>();
       
        String val2 = map1.get(str2);
        if (map1.getOrDefault(str1, "").isEmpty()) {
        	map1.put(str1, "Deb");
        }
        
        if (map1.get(str2) == null) {
        	map1.put(str2, "Debbie");
        	
        }
        System.out.println("Pinting map ...");
        for (Map.Entry<String,String> entry : map1.entrySet()) {
        	System.out.println(entry.getKey()+" "+ entry.getValue());
        }
        if(map1.containsKey(str2)) {
        	map1.put(str2, map1.get(str2)+" = Debanjana");
        }
        map1.values();
        map1.keySet();
        map1.size();
        //map1.put(str2, newVal);
        System.out.println("Pinting map after changing value ...");
        for (Map.Entry<String,String> entry : map1.entrySet()) {
        	System.out.println(entry.getKey()+" "+ entry.getValue());
        }
        map1.put("Microsoft", "Hyderabad");
        System.out.println("Pinting map ...");
        for (Map.Entry<String,String> entry : map1.entrySet()) {
        	System.out.println(entry.getKey()+" "+ entry.getValue());
        }
        System.out.println("Pinting keys ...");
        for (String keys : map1.keySet()) {
        	System.out.println(keys);
        }
        map1.put("Microsoft", "Redmond");
        
        System.out.println("Pinting values ...");
        for (String values : map1.values()) {
        	System.out.println(values);
        }
        System.out.println(map1.size());
        List<String>values = new ArrayList<String>(map1.values());
        Collections.sort(values);
        
        
        int[] arr = new int[3];
        Arrays.fill(arr, -1);
        List<int[]> la = new ArrayList<int[]>();
        la.add(arr.clone());
        Arrays.sort(arr, 1, arr.length);
        
       
        final int min = Integer.MIN_VALUE;
        Math.max(min, Integer.MAX_VALUE);
        System.out.println(Math.abs(-1.5));
        System.out.println(Math.floor(1.5));
        System.out.println(Math.ceil(1.5));
        Stack<Integer>stk = new Stack<Integer>();
        stk.push(1);
        stk.peek();
        stk.pop();
        stk.size();
        
        
        Queue<String> q = new LinkedList<String>();
        q.add("a");
        q.peek();
        q.poll();
        q.offer("b");
        q.remove("b");
        q.add("c");
        q.isEmpty();
        q.size();
        
        ArrayDeque<String> dq = new ArrayDeque<String>(); // Add at end remove from beginning
        dq.addFirst("a");
        dq.addLast("b");
        dq.add("c");
        dq.getFirst();
        dq.getLast();
        dq.peekFirst();//same as getFirst but no exception, same as peek
        dq.peek();
        dq.peekLast();
        dq.size();
        
        Queue<Integer> pq = new PriorityQueue<Integer>(); // Default min heap ascending order
        pq.add(7);
        pq.add(11);
        pq.add(-1);
        
        System.out.println(pq);
        
        Queue<Integer> pqMax = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return (o2.compareTo(o1));
				
			}
        	
        	
        });
        pqMax.add(7);
        pqMax.add(11);
        pqMax.add(-1);
        
        System.out.println(pqMax);
        
       String s = "Doyel";
       char[]dchar = s.toCharArray();
       String y = dchar.toString();// THIS DOES NOT WORK
       String z = new String(dchar);
       String w = String.valueOf(dchar);
       for(char c : s.toCharArray()) {
    	   System.out.print(c);
       }
       System.out.println();
       for(int i = 0; i < s.length(); i++) {
    	   System.out.print(s.charAt(i));
       }
       
       char[] ch = new char[1];
       ch[0] = 'a';
       
       System.out.println("\n"+ y + " "+ z + " "+ w);
       String d = "Debbie";
   	   System.out.println(d.substring(0, 1));
   	   boolean ans =  map1.containsKey("a");
   	   
   	   StringBuilder sb = new StringBuilder();
   	   sb.append("x");
   	   sb.append("y");
   	   sb.deleteCharAt(sb.length()-1);
   	   ArrayList<String> ans2 = new ArrayList<String>();
   	   ans2.add(sb.toString());
   	   ans2.size();
	}
	
	

	//HashSet<int>	
	//  foreach(int val in arr) {
    //set.Add(val);
	// addrange

}
