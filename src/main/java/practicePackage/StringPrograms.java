package practicePackage;

public class StringPrograms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Count number of words in a string
		String str = "Hello World";
		String[] words = str.split(" ");
		System.out.println("Number of words in the string: "+words.length);
		
		//Count the number of vowels in a string using recursion
		String str1 = "Hello World";
		System.out.println("Number of vowels in the string: "+countVowels(str1));
		
		//Count if the string is palindrome
		String str2 = "madam";
		System.out.println("Is the string palindrome: "+isPalindrome(str2));
		
		//Reverse the string
		String str3 = "Hello World";
		System.out.println("Reversed string: "+reverseString(str3));
		
		//Count the number of words in a string
		String str4 = "Hello World";
		System.out.println("Number of words in the string: "+countWords(str4));
		
		//Check if the string is anagram
		String str5 = "listen";
		String str6 = "silent";
		System.out.println("Are the strings anagram: "+isAnagram(str5,str6));
		
		
	}

	private static String isAnagram(String str5, String str6) {
		// TODO Auto-generated method stub
		if (str5.length() != str6.length()) {
			return "No";
		}
		char[] str5Array = str5.toCharArray();
		char[] str6Array = str6.toCharArray();
		java.util.Arrays.sort(str5Array);
		java.util.Arrays.sort(str6Array);
		for (int i = 0; i < str5Array.length; i++) {
			if (str5Array[i] != str6Array[i]) {
				return "No";
			}
		}
		return "Yes";
	}

	private static String countWords(String str4) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < str4.length(); i++) {
			if (str4.charAt(i) == ' ') {
				count++;
			}
		}
		count++;
		if (count > 0) {
			return count + "";
		}
		
        return "0";	
        }

	private static String reverseString(String str3) {
		// TODO Auto-generated method stub
		String reverse = "";
		for (int i = str3.length() - 1; i >= 0; i--) {
			reverse = reverse + str3.charAt(i);
		}
		return reverse;
	}

	private static String isPalindrome(String str2) {
		// TODO Auto-generated method stub
		String reverse = "";
		for (int i = str2.length() - 1; i >= 0; i--) {
			reverse = reverse + str2.charAt(i);
		}
		if (str2.equals(reverse)) {
			return "Yes";
		} else {
			return "No";
		}
	}

	private static int countVowels(String str1) {
		// TODO Auto-generated method stub
		char[] vowels = {'a','e','i','o','u'};
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < vowels.length; j++) {
				if (str1.charAt(i) == vowels[j]) {
					count++;
				}
			}
		}
		return count;
	}

	
	
}
