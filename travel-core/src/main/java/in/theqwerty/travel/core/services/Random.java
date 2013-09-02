package in.theqwerty.travel.core.services;

public final class Random {

	public static int rInt(int upperLimit) {
		java.util.Random random = new java.util.Random();
		return random.nextInt(upperLimit);
	}
	public static int rInt(int upperLimit, int[] array) {
		int result = -1;
		while(result == -1) {
			result = rInt(upperLimit);
			if(contains(result, array)) {
				result = -1;
			}
		}
		return result;
	}
	public static char rSpecialChar() {
		char [] array = {'<','>','?','!','@','#','$','%','^','&','*','(',')','_','-'};
		return array[rInt(array.length)];
	}
	public static char rDigitChar() {
		char [] array = {'0','1','2','3','4','5','6','7','8','9'};
		return array[rInt(array.length)];
	}
	
	private static boolean contains(int num, int[] array) {
		for(int i : array){
			if(i == num) {
				return true;
			}
		}
		return false;
	}
	
	public static char rChar() {
		if(rInt(2) == 0) {
			return (char)('A'+rInt(26));
		}
		else {
			return (char)('a'+rInt(26));
		}
	}
}
