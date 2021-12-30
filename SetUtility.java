import java.util.List;
import java.util.ArrayList;

public class SetUtility {

	public static List<ArrayList<String>> iterativePowerSet(List<String> inputList){
		List<ArrayList<String>> powerSet = new ArrayList<>();
		int n = inputList.size();
		long total = (long)Math.pow(2, n);
		for(int i = 0 ; i < total ; i++){
			ArrayList<String> list = new ArrayList<String>();
			for(int input = 0 ; input < n ; input++){
				if((i & (1 << input)) > 0)
					list.add(inputList.get(input));
			}
			powerSet.add(list);
		}
		return powerSet;
	}

	public static void recursivePowerSet(
		List<String> inputList,
		ArrayList<String> output,
		int currentIndex,
		List<ArrayList<String>> outputList
	){
		if(currentIndex == inputList.size()){
			outputList.add(output);
			return;
		}		
		recursivePowerSet(inputList, new ArrayList<String>(output), currentIndex + 1, outputList);
		output.add(inputList.get(currentIndex));
		recursivePowerSet(inputList, new ArrayList<String>(output), currentIndex + 1, outputList);
	}

	public static List<String> getPermutations(String input){
		List<String> permutations = new ArrayList<String>();
		int n = input.length();
		permute(input, permutations, 0, n-1);
		return permutations;
	}

	private static void permute(String input, List<String> permutations, int startIndex, int endIndex){
		if(startIndex == endIndex){
			permutations.add(input);
			return;
		}
		for(int i = startIndex ; i <= endIndex ; i++){
			input = swap(input, i, startIndex);
			permute(input, permutations, startIndex + 1, endIndex);
			input = swap(input, i, startIndex);
		}
	}

	private static String swap(String s, int i, int j){
		char[] input = s.toCharArray();
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		return String.valueOf(input);
	}

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		while(!StdIn.isEmpty()){
			words.add(StdIn.readString());
		}
		StdOut.println("Input words are: " + words);
		StdOut.println("Power set of these words are (iterative)\n: " + iterativePowerSet(words));
		List<ArrayList<String>> subset = new ArrayList<>();
		recursivePowerSet(words, new ArrayList<String>(), 0, subset);
		StdOut.println("Power set of these words are (recursive)\n: " + subset);
		StdOut.println("All permutations of string ABCDEF are: ");
		StdOut.println(getPermutations("ABCDEF"));
	}
}