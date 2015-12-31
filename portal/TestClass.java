package portal;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

public class TestClass {
	
	public static void main(String[] args) {
		
		String s = "Novopay Solutions @#$%";
		
		byte[] base64Encoded = Base64.encodeBase64(s.getBytes());
		System.out.println("base64 encoded string: " + new String(base64Encoded));
		
		byte[] decoded = Base64.decodeBase64(base64Encoded);
		System.out.println("base64 decoded string: " + new String(decoded));
		
		if(StringUtils.isNotBlank(s)) {
			System.out.println("Is Not Blank");
		} else {
			System.out.println("Is Blank");
		}
		
	}
}
