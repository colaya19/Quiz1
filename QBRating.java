import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
public class QBRating {
	
	static int attempts = 0;
	static int completions = 0;
	static int passyrds = 0;
	static int tds = 0;
	static int ints = 0;
	
	static Scanner scanns = new Scanner(System.in);
	

	public static void main(String[] args) 
	{
		System.out.println("Enter Number of Passing Attempts:");
		attempts = scanns.nextInt();
		System.out.println("Enter Number of Completions:");
		completions = scanns.nextInt();
		System.out.println("Enter Total Passing Yards:");
		passyrds = scanns.nextInt();
		System.out.println("Enter Total Touchdowns:");
		tds = scanns.nextInt();
		System.out.println("Enter Total Interceptions:");
		ints = scanns.nextInt();
		
		DecimalFormat df = new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.CEILING);
		
		System.out.println(df.format((PasserRating(CompPercent(),YrdAtt(),TdAttempt(),intAttempt()))));
		
		
	}
	public static double PasserRating(double compperc, double yrdattempt, double tdattempt, double intattempt)
	{
		if (((compperc + yrdattempt + tdattempt + intattempt)/6)*100 > 158.3)
			return 158.3;
		else if(((compperc + yrdattempt + tdattempt + intattempt)/6)*100 < 0)
			return 0;
		else
			return ((compperc + yrdattempt + tdattempt + intattempt)/6)*100;
	}
	public static double CompPercent()
	{		
		if (((((double)completions/attempts)-0.3)*5) > 2.375)
			return 2.375;
		else if (((((double)completions/attempts)-0.3)*5) < 0)
			return 0;
		else
			return ((((double)completions/attempts)-0.3)*5);
	}
	public static double YrdAtt()
	{
		if (((((double)passyrds/attempts)-3)*0.25) > 2.375)
			return 2.375;
		else if (((((double)passyrds/attempts)-3)*0.25) < 0)
			return 0;
		else
			return ((((double)passyrds/attempts)-3)*0.25);
	}
	public static double TdAttempt()
	{
		if ((((double)tds/attempts)*20) > 2.375)
			return 2.375;
		else if((((double)tds/attempts)*20) < 0)
			return 0;
		else
			return (((double)tds/attempts)*20);
	}
	public static double intAttempt()
	{
		if ((2.375-(((double)ints/attempts)*25)) > 2.375)
			return 2.375;
		else if ((2.375-(((double)ints/attempts)*25)) < 0)
			return 0;
		else
			return (2.375-(((double)ints/attempts)*25));
	}
}
