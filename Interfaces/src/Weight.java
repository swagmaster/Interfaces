import java.io.Serializable;

/*
 * Adam Atienza
 * 
 * Weight class takes in pounds and ounces, sets and intializes the variables.
 * The weight class has add functions to add pounds or pounds and ounces or another 
 * weight object. Implements some interfaces for function use.
 */

public class Weight implements Comparable<Weight>, Cloneable, Serializable {
	
	private int pounds, ounces;

	/*
	 * Weight constructor takes in just pounds and intializes it accordingly.
	 */
	public Weight(int lbs) {
		if(lbs < 0) {
			System.out.println("Weight cannot be negative.");
		} else {
			pounds = lbs;
		}
		ounces = 0;
	}
	
	/*
	 * Weight constructor takes in both pounds and ounces and initalizes it accordingly.
	 */
	public Weight(int lbs,int ounces) {
		if(lbs < 0) {
			System.out.println("Weight cannot be negative.");
			pounds = 0;
		} else {
			pounds = lbs;
		}
		if(ounces < 0) {
			System.out.println("Weight cannot be negative.");
			this.ounces=0;
		} else if(ounces > 15) {
			System.out.println("Ounces cannot be greater than 15.");
			this.ounces = 15;
		} else {
			this.ounces = ounces;
		}
	}
	
	/*
	 * Weight copy constructor sets current object to a copy of that object
	 */
	public Weight(Weight other) {
		System.out.println("Error. Use clone() method.");
	}
	
	/*
	 * Clone method uses the clone interface method to make
	 * another copy of the Weight object.
	 */
	public Weight clone(){
		try {
		    Weight newWeight = (Weight) super.clone();
		    return newWeight;
		} catch (CloneNotSupportedException e){ 
		    return null;
		}
	}
	
	/*
	 * getPounds() returns the current pounds of the weight.
	 */
	public int getPounds() {
		return pounds;
	}
	
	/*
	 * setPounds() allows for the pounds to be changed or 'set' to a different value of pounds.
	 */
	public void setPounds(int pounds) {
		if(pounds < 0) {
			System.out.println("Weight cannot be negative.");
			this.pounds = 0;
		} else {
			this.pounds = pounds;
		}
	}
	
	/*
	 * getOunces() returns the current ounces of the weight.
	 */
	public int getOunces() {
		return ounces;
	}
	
	/*
	 * setOunces() allows for the ounces to be changed or 'set' to a different value of ounces.
	 */
	public void setOunces(int ounces) {
		//setting class invariant for ounces
		if(ounces < 0) {
			System.out.println("Weight cannot be negative.");
			this.ounces = 0;
		} else if(ounces > 15) {
			System.out.println("Ounces cannot be greater than 15.");
			this.ounces = 15;
		} else {
			this.ounces = ounces;
		}
	}

	/*
	 * getWeight() returns the weight in the form: lbs. oz. in type double
	 */
	public double getWeight() {
		return pounds + (double)(ounces)/16;
	}
	
	/*
	 * Sets the weight accordingly with parameters pounds and ounces.
	 */
	public void setWeight(int pounds, int ounces) {
		setPounds(pounds);
		setOunces(ounces);
	}
	
	/*
	 * add() takes in a pounds value and adds it to the current pounds.
	 */
	public void add(int lbs) {
		//checks if lbs isn't negative
		if(lbs >= 0) {
			pounds += lbs;
		} else {
			System.out.println("Cannot add negative pounds.");
		}
	}
	
	/*
	 * another add function that takes in a lbs and a oz and adds it accordingly.
	 */
	public void add(int lbs, int oz) {
		//checks if lbs and oz isn't negative
		if(lbs >= 0) {
			pounds += lbs;
		} else {
			if(pounds-lbs < 0) {
				System.out.println("Pounds cannot be negative.");
			} else {
				pounds -= lbs;
			}
		}
		//checks if additional oz goes over 15 or not.
		if(ounces + oz >= 0 && ounces + oz <= 15) {
			ounces += oz;
		} else if(ounces + oz > 15) {
			System.out.println("Ounces must be over 15.");
		} else {
			System.out.println("Ounces cannot be negative.");
		}
	}
	
	/*
	 * another add function that takes in an already set weight and adds it to the current weight.
	 */
	public void add(Weight other) {
		//checks the values of the inputted weight.
		if(other.pounds<0 || other.ounces<0 || other.ounces>15) {
			System.out.println("Weight cannot be negative.");
		} else {
			add(other.pounds,other.ounces);
		}
	}
	
	/*
	 * Checks to see if another object equals the current set weight object.
	 */
	public boolean equals(Object o) {
		if (o == null)   
			return false;
		if (o == this)
			return true;
		return pounds ==((Weight)o).pounds && ounces==((Weight)o).ounces;
	}
	
	/*
	 * Puts the weight in string form.
	 */
	public String toString() {
		return pounds+" lbs. "+ounces+" oz.";
	}

	/*
	 * compareTo() method takes in another Weight object and compares it
	 * to current weight object. It will return a number to indicate if
	 * the objects are equal or not.
	 */
	@Override
	public int compareTo(Weight other) {
		return this.toString().compareTo(other.toString());
	    
	}
}
