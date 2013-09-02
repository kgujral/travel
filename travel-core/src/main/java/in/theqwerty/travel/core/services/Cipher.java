package in.theqwerty.travel.core.services;

public final class Cipher {

	public static final int CIPHER_LENGTH = 24;
	
	public static String encrypt(final String textString) {
		char[] cipher = new char[CIPHER_LENGTH];
		char[] text = textString.toCharArray();
		int [] indices = new int[CIPHER_LENGTH];
		final int length = textString.length();
		
		for(int i = 0 ; i < length ; i++) {
			indices[i] = i*2;
		}
		indices[length] = length * 2;
		for(int i = 0; i < length; i++ ) {
			int index = Random.rInt(CIPHER_LENGTH, indices);
			indices[length + i+1] = index;
			cipher[index] = text[i];
			if(i == 0) {
				if(Random.rInt(3) == 1) {
					cipher[indices[i]] = (char) ('A' + index);
				}
				else {
					cipher[indices[i]] = (char) ('a' + index);
				}
			}
			else {
				if(Character.isLowerCase(cipher[indices[i-1]])) {
					cipher[indices[i]] = (char) ('A' + index);
				}
				else {
					cipher[indices[i]] = (char) ('a' + index);
				}
			}
		}
		
		if(Character.isUpperCase(cipher[indices[length - 1]])) {
			cipher[indices[length]] = (char)('A' + Random.rInt(25)); 
		}
		else {
			cipher[indices[length]] = (char)('a' + Random.rInt(25)); 
		}
		
		
		
		for(int i = 0; i < CIPHER_LENGTH ; i++ ) {
			if(cipher[i] == '\u0000') {
				if(Random.rInt(5) > 1) {
					cipher[i] = Random.rSpecialChar();
				}
				else {
					cipher[i] = Random.rDigitChar();
				}
				
			}
		}
		
		StringBuilder result = new StringBuilder();
		for(int i=0;i<CIPHER_LENGTH;i++) {
			result.append(cipher[i]);
		}
		
		return result.toString();
	}
	
	public static String decrypt(final String cipher) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < CIPHER_LENGTH; i+=2) {
			int index = 0;
			char current = cipher.charAt(i);
			if(Character.isUpperCase(current)) {
				index = current - 'A';
			}
			else {
				index = current - 'a';
			}
			if(Character.isUpperCase(current) && Character.isUpperCase(cipher.charAt(i+2))
			 ||Character.isLowerCase(current) && Character.isLowerCase(cipher.charAt(i+2))) {
				i = CIPHER_LENGTH + 1;
			}
			result.append(cipher.charAt(index));
		}
		return result.toString();
	}
}
