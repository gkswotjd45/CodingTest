package level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Programmes_전화번호목록 {
	static class Solution {
	    public boolean solution(String[] phone_book) {
	    	Arrays.sort(phone_book);

	        for (int i = 0; i < phone_book.length - 1; i++) {
	            if (phone_book[i+1].startsWith(phone_book[i])) {
	                return false;
	            }
	        }

	        return true;
	    }
//	        boolean answer = false;
//	        
//	        Set<String> list = new LinkedHashSet<>();
//	        
//	        for(int i = 0 ; i<phone_book.length; i++) {
//	        	list.add(phone_book[i]);
//	        }
//	        
//	        Iterator<String> iter = list.iterator();
//	        int j = 0;
//	        while (iter.hasNext()) {
//	        	for(int i = 0; i<phone_book[0].length(); i++) {
//	        		char[] text = iter.next().toCharArray();
//	        		if(phone_book[1+j].charAt(i)!=text[i]) {
//	        			answer= true;
//	        			break;
//	        		}
//	        		answer = false;
//	        	}
//	        	j++;
//	        }
//	          
//	        return answer;
//	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String [] arr = {"123","456","789"};
		String [] ar1 = {"12", "123", "1235", "567", "88"};
		
//		String [] arr = {"119", "97674223", "1195524421"};
		boolean result = solution.solution(ar1);
		System.out.println(result);
	}
}
