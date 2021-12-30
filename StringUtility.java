public class StringUtility {

	public static String iterativeStringReverse(String input){
		StringBuilder sb = new StringBuilder();
		int n = input.length();
		for(int i = n-1; i >= 0; i--)
			sb.append(input.charAt(i));
		return sb.toString();
	}

	public static String iterativeStringReverseTwoPointers(String input){
		char[] charArray = input.toCharArray();
		for(int i = 0, j = charArray.length-1; i < j;){
			swap(charArray, i++, j--);			
		}
		return String.valueOf(charArray);
	}

	private static void swap(char[] input, int i, int j){
		char temp = input[i];
		input[i] = input[j];
		input[j] =temp;
	}

	public static String recursiveStringReverse(String input){
		StringBuilder sb = new StringBuilder();
		int n = input.length();
		recursiveStringReverse(input, n-1, sb);
		return sb.toString();
	}

	private static void recursiveStringReverse(String input, int index, StringBuilder sb){
		sb.append(input.charAt(index));
		if(index == 0)	return;		
		recursiveStringReverse(input, index - 1, sb);
	}

	public static void main(String[] args) {
		String s = StdIn.readString();
		StdOut.println("Given String is: " + s);
		StdOut.println("String reversed using iterative approach: " + iterativeStringReverse(s));
		StdOut.println("String reversed using recursive approach: " + recursiveStringReverse(s));
		StdOut.println("String reversed using recursive approach: " + iterativeStringReverseTwoPointers(s));
	}
}