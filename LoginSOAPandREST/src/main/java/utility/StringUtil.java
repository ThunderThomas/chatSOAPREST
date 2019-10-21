package utility;

public class StringUtil {
	private StringUtil() {
	}

	public static boolean isEmptyOrNull(String string) {
		return string == null || string.trim().equals("");
	}
}
