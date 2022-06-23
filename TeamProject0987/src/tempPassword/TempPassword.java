package tempPassword;

public class TempPassword {

	public String temp_password = "";
	public TempPassword() {
		
		String symbols = "abcdefghijklmnopqrstuvwxyz" 
				+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "!\"#$%&'()*+,-./:;<=>?@{}^_`{|}~//";
		
		for (int i = 0; i < 12; ++i) {
		int random_index = (int)(Math.random() * symbols.length());
		char random_char = symbols.charAt(random_index);
		temp_password += random_char;
		}
	}
}
