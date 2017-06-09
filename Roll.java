package DiceRoller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Hashtable;

public class Roll 
{
	public static void main(String[] args) 
	{
		// setup
		int iSides = 6;
		int iRuns = 600000000;
		ArrayList<Integer> alDie = new ArrayList<Integer>(iSides); // make die
		Hashtable<Integer, Integer> htTrials = new Hashtable<Integer, Integer>(); // make counter
		for (int i=1; i<=iSides; i++)
		{
			alDie.add(i);  // add digits to die
			htTrials.put(i, 0); // start counts at 0 for each digit
		}
		// run trials
		Calendar startTime = Calendar.getInstance();
		for (int j=0; j<iRuns; j++)
		{
			Collections.shuffle(alDie);
			int result = alDie.get(0);
            htTrials.put(result, (Integer) htTrials.get(result).intValue() + 1);
		}
		Calendar stopTime = Calendar.getInstance();
		// print results
		for (int k=1; k<=iSides; k++)
		{
			int iTally = htTrials.get(k);
			double iPercentage = (double) iTally / iRuns * 100;
			System.out.println(k + "\t" + 
                DiceUtils.formatInt(iTally)+ "\t" +
                DiceUtils.formatPercentage(iPercentage));
		}
		System.out.println ("runtime (sec): \t" + DiceUtils.TimeInSeconds(startTime, stopTime));
	}
}
