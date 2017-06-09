package DiceRoller;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class DiceUtils 
{
	private static DecimalFormat dfPercentage = new DecimalFormat("##.###");
	public static String formatInt(int i)
	{
		return NumberFormat.getNumberInstance(Locale.US).format(i);
	}
	public static String formatPercentage(double d)
	{
		return DiceUtils.dfPercentage.format(d);
	}
	public static int sumDigits (int number)
	{
		int answer = 0;
        while (number > 0) 
        {
            answer = answer + number % 10;
            number = number / 10;
        }
        return answer;
	}
	public static int createRepeatingDigits (int digit, int len) // digit 1-9, len 1-9
	{
		int answer = digit;
		for (int i=1; i<len; i++)
		{
			answer *= 10;
			answer += digit;
		}
		return answer;
	}
	public static int createRepeatingDigits2 (int digit, int len) // digit 1-9, len 1-9
	{
		int answer = 0;
		for (int i=0; i<len; i++)
			answer += digit * Math.pow(10, i);
		return answer;
	}
	public static boolean filterNumberRange(int num, int maxValue)
	{
		return filterNumberRange(num, 1, maxValue);
	}
	public static boolean filterNumberRange(int num, int minValue, int maxValue) 
	{		
		while (num > 0) 
		{
			int check = num % 10;
			if (check < minValue || check > maxValue)
				return false;
			num = num / 10;
		}
		return true;
	}
	public static double GetPercentageDifference(double x, double y)
    		   { return (y - x) / x * 100;     }
	public static double TimeInSeconds (Calendar start, Calendar end)       
           { return ((end.getTime().getTime() - start.getTime().getTime())/1000); }
}
