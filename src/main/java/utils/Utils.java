package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	public static Boolean FindValueInString(String ValueToCheck,String Compare)
	{
		String pattern = "\\b" + Compare + "\\b";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(ValueToCheck);
		return m.find();
	}
}
