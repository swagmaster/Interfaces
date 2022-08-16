import java.io.Serializable;

/*
 * 
 * Adam Atienza
 * 
 * YoungHuman consists of class variables that can be changed.
 * Check up dates can be set and it checks to see if they fit within
 * the class invariants.The class also gets the values of Date and Weight
 * by getting copies of those objects. Implements some interfaces for function use.
 */
public class YoungHuman implements Comparable<YoungHuman>, Cloneable, Serializable {
	
	private Weight currentWeight;
	private Date birthDate, lastCheckUpDate;
	private String firstName, lastName;
	
	/*
	 * Constructor takes in a weight object, a date object, and first and last name and initializes accordingly. 
	 * Sets checkupdate to null.
	 */
	public YoungHuman(Weight currentWeight, Date birthDate, String firstName, String lastName){
		this.currentWeight = currentWeight;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
		lastCheckUpDate = null;
	}
	
	//Copy constructor sets objects to a new copy using the same values
	public YoungHuman(YoungHuman toCopy) {
		System.out.println("Error. Use clone() method.");
	}
	
	/*
	 * Clone method uses the clone interface method to make
	 * another copy of YoungHuman object.
	 */
	public YoungHuman clone(){
		try {
		    YoungHuman newYH = (YoungHuman) super.clone();
		    newYH.currentWeight = this.currentWeight.clone();
		    newYH.birthDate = this.birthDate.clone();
		    if(hasHadCheckUp()){
		    	newYH.lastCheckUpDate = this.lastCheckUpDate.clone();
		    }
		    return newYH;
		} catch (CloneNotSupportedException e) {
		    System.out.println(e);
		    return null;
		}
		
	}


	/*
	 * getBirthDate() returns a copy of the set birthdate.
	 */
	public Date getBirthDate() {
		return new Date(this.birthDate);
	}
	
	/*
	 * getLastCheckUpDate() returns a copy of the last check up date if there is one.
	 */
	public Date getLastCheckUpDate() {
		return new Date(this.lastCheckUpDate);
	}
	
	/*
	 * getName() returns the objects first and last name.
	 */
	public String getName() {
		return firstName + " " + lastName;
	}
	
	/*
	 * Checks to see if there is an exisiting check up date.
	 */
	public boolean hasHadCheckUp() {
		return lastCheckUpDate != null;
	}
	
	/*
	 * Sets check up date for YoungHuman
	 */
	public void setCheckUp(Date dateOfCheckUp) {
		//class invariant checks if the check up date is after the birthdate.
		if(dateOfCheckUp.getYear() > birthDate.getYear())
			this.lastCheckUpDate = dateOfCheckUp;
		else
			System.out.println("Check up date cannot be before birth date.");
	}
	
	/*
	 * Changes the check up date to null.
	 */
	public void unsetCheckUpDate() {
		lastCheckUpDate = null;
	}
	
	/*
	 * setBirthDate() allows for the birthdate to be changed or 'set' to a different Date.
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = new Date(birthDate.getMonth(), birthDate.getDay(), birthDate.getYear());
	}
	
	/*
	 * setWeight() allows for a weight to be passed in as the current weight of the YoungHuman.
	 */
	public void setWeight(Weight amount) {
		currentWeight = new Weight(amount);
	}
	
	/*
	 * getWeight() returns a copy of the current weight of the YoungHuman.
	 */
	public Weight getWeight() {
		return new Weight(this.currentWeight);
	}
	
	/*
	 * setName() initializes the first and last name into the class.
	 */
	public void setName(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}
	
	/*
	 * Puts the information of the YoungHuman into a string.
	 */
	public String toString() {
		String str = getName() + ", " + currentWeight.toString() + ", birth date: " + birthDate.toString();
		if(hasHadCheckUp()) {
			str += ", last check-up: " + lastCheckUpDate.toString();
		} else {
			str += ", has not had a check-up.";
		}
		return str;
	}

	/*
	 * Checks to see if another YoungHuman object has the same memory address or has the same values as the current 
	 * YoungHuman.
	 */
	public boolean equals(Object other) {
	    if( other != null && ! (other instanceof YoungHuman)) {
	    	return false;
	    }
	    
	    YoungHuman that = (YoungHuman) other;
	    if(that == other) {
	    	return true;
	    }
	    return false;
	}

	/*
	 * compareTo() method takes in another YoungHuman object and compares it
	 * to current younghuman object. It will return a number to indicate if
	 * the objects are equal or not.
	 */
	@Override
	public int compareTo(YoungHuman other) {
		return this.toString().compareTo(other.toString());
		
	}

}