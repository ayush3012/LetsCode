package JavaCode;

/*
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
 * Input: date = "2019-02-10"
   Output: 41*/
public class DayOfTheyear1154 {
	
	public int dayOfYear(String date) {

		String[] dates=date.split("-");
		int year=Integer.valueOf(dates[0]);
		int month=Integer.valueOf(dates[1]);
		int day=Integer.valueOf(dates[2]);
		int[] m= {31,28,31,30,31,30,31,31,30,31,30,31};
		if(isLeapYear(year))
			m[1]=29;
		int res=0;
		int i=0;
		while(month-->1)
			res+=m[i++];
		res+=day;
		return res;
	}

	public boolean isLeapYear(int year)
	{
		if((year%4==0 && year%100!=0) || (year%400==0))
			return true;
		else return false;
	}
	public static void main(String[] args) {
		
		String date = "2019-01-09";
		//String date = "2019-02-10";
		//String date = "2003-03-01";
		
		System.out.println(new DayOfTheyear1154().dayOfYear(date));

	}

}
