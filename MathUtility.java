import java.util.Map;
import java.util.HashMap;

public class MathUtility {	

	private static long recursiveBinaryPower(long a, int n){
		
		if(n == 0){
			return 1;
		}
		long result = recursiveBinaryPower(a, n/2);
		
		if(n % 2 == 1)
			result *= (result * a);
		else
			result *= result;
		
		return result;
	}

	private static long iterativeBinaryPower(long a, int n){
		// System.out.println("iterativeBinaryPower is called...");
		long result = 1;
		while(n > 0){
			// System.out.println("Inside while loop...");
			if((n & 1) == 1)
				result *= a;
			a *= a;
			n >>= 1;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Testing recursiveBinaryPower() method:...");
		System.out.println("recursiveBinaryPower(3, 13) = " + recursiveBinaryPower(3, 13));
		System.out.println("Testing iterativeBinaryPower() method:...");
		System.out.println("iterativeBinaryPower(3, 13) = " + iterativeBinaryPower(3, 13));
	}
}