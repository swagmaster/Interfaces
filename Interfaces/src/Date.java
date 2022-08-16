import java.io.Serializable;

/*
 * Adam Atienza
 * 
 * The Date class takes in the month, year, and sets initializes them accordingly.
 * Implements some interfaces for function use.
 */
public class Date implements Comparable<Date>, Cloneable, Serializable {
	
	private int month, day, year;
	
	/*
	 * Date constructor takes in the month, day, and initializes it accordingly
	 */
	public Date(int month, int day, int year) {
		//setting class invariants for the date
		if(day < 1 || day > 31) {
			System.out.println("Day must be 1-31");
			this.day = 1;
		} else {
			this.day = day;
		}
		if(month < 1 || month > 12) {
			System.out.println("Month must be 1-12");
			this.month = 1;
		} else {
			this.month = month;
		}
		if(year < 2014 || day > 2024) {
			System.out.println("Year must be 2014-2024");
			this.year = 2014;
		} else {
			this.year = year;
		}
	}
	/*
	 * Date copy constructor sets the date to the 'other' copy of date.
	 */
	public Date(Date other) {
		System.out.println("Error. Use clone() method.");
	}
	
	/*
	 * Clone method uses the clone interface method to make
	 * another copy of the Date object.
	 */
	public Date clone(){
		try {
		    Date newDate = (Date) super.clone();
		    return newDate;
		} catch (CloneNotSupportedException e){ 
		    return null;
		}
	}
	/*
	 * getMonth() will return the month of the set date.
	 */
	public int getMonth() {
		return month;
	}
	
	/*
	 * setMonth() allows for the month to be changed or 'set' to a different month.
	 */
	public void setMonth(int month) {
		//setting class invariant for months
		if(month < 1 || month > 12) {
			System.out.println("Month must be 1-12");
			this.month = 1;
		} else {
			this.month = month;
		}
	}
	
	/*
	 * getYear() will return the year of the set date.
	 */
	public int getYear() {
		return year;
	}
	/*
	 * setYear() allows for the year to be changed or 'set' to a different year.
	 */
	public void setYear(int year) {
		//setting class invariant for year
		if(year < 2014 || day > 2024) {
			System.out.println("Year must be 2014-2024");
			this.year = 2014;
		} else {
			this.year = year;
		}
	}
	
	/*
	 * getDay() will return the day of the set date.
	 */
	public int getDay() {
		return day;
	}
	
	/*
	 * setDay() allows for the day to be changed or 'set' to a different day.
	 */
	public void setDay(int day) {
		//setting class invariant for days in a month
		if(day < 1 || day > 31) {
			System.out.println("Day must be 1-31");
			this.day = 1;
		} else {
		this.day = day;
		}
	}
	
	/*
	 * Returns the date in form mm/dd/yyyy
	 */
	public Date getDate(){	
		return this;	
	}
	
	/*
	 * setDate() is the Date of the object.
	 */
	 public void setDate(Date other){
		this.setDay(other.day);
		this.setMonth(other.month);
		this.setYear(other.year);
		
	 }
		    
	/*
	 * Checks to see if another object is equal to the current Date object.
	 */
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
			return false;
		}
		if (otherObject == this) {
			return true;
		}
		
		return year==((Date)otherObject).getYear() && day==((Date)otherObject).getDay() && month==((Date)otherObject).getMonth();
	}
	
	/*
	 * Puts the month, day, and year in string form
	 */
	public String toString() {
		return month + "/" + day + "/" + year;
	}
	/*
	 * compareTo() method takes in another Date object and compares it
	 * to current date object. It will return a number to indicate if
	 * the objects are equal or not.
	 */
	@Override
	public int compareTo(Date other) {
		// TODO Auto-generated method stub
		return this.getDate().compareTo(other.getDate());
		
	}
}