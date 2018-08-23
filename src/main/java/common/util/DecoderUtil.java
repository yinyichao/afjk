package common.util;

import java.io.UnsupportedEncodingException;

public class DecoderUtil {
	public static String decode(String key){
		if(key != null)
			try {
				key=java.net.URLDecoder.decode(key, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		return key;
	}
}
