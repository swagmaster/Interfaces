
/*
 * Adam Atienza
 * 
 * Driver method tests the classes.
 */
public class Driver {

	
	public static void main(String[] args)
    {		
		
		//Date Class Tests
		Date date1 = new Date(10, 12, 2019);
		System.out.println("date1 = " + date1);
		Date date2 = new Date(7, 3, 2020);
		System.out.println("date2: " + date2);
		date2.setDate(date1);
		System.out.println("Set the value of date2 to date1 using setDate(). Date2 is: " + date2);
		date2.setYear(2023); 
		
		//Weight Class Tests:
		Weight weight1 = new Weight(7);
		System.out.println("Value of weight1: " + weight1.toString());
		
		Weight weightClone = weight1.clone();
		System.out.println("Testing clone method. Cloned " + weight1.toString() + 
			" to object weightClone with a value of " + weightClone.toString());
		
		System.out.println("Now making another Money object with two arguments. One for dollars and one for cents.");
		Weight weight2 = new Weight(7, 4);
		System.out.println("Value of weight2: " + weight2.getWeight());
		
		System.out.println("Does weight1 equal weight2?: " + weight1.equals(weight2));
		weight1.setOunces(4);
		System.out.println("Does weight1 equal weight2?: " + weight1.equals(weight2));
		System.out.println("Using the compareTo() method: " + weight1.compareTo(weight2));
		
		weight2.setWeight(14,  14);
		System.out.println("weight2 is now: " + weight2);
		System.out.println("Now using the compareTo() method: " + weight1.compareTo(weight2));
		weight1.add(7, 10);
		System.out.println("Changing weight1. It is now: "+ weight1.toString());
		System.out.println("Using the compareTo() method: " + weight1.compareTo(weight2));
		
		//YoungHuman Class Tests: 
		YoungHuman y1 = new YoungHuman(weight1, date1, "Bill", "Clinton");
		System.out.println("Current Child --> " + y1);
		y1.setBirthDate(date2);
		System.out.println("Updated birthdate --> " + y1);
		YoungHuman yClone = y1.clone();
		System.out.println("Testing clone method. Cloned " + y1.toString() + 
				" to object weightClone with a value of " + yClone.toString());
		System.out.println("Using the compareTo() method: " + y1.compareTo(yClone));
		
		//ChildCohort Class Tests:
		ChildCohort child1 = new ChildCohort();
		child1.addAChild(y1);
		YoungHuman y2 = new YoungHuman(weight2, date2, "Chris", "Pratt");
		child1.addAChild(y2);
		
		System.out.println("Printing ChildCohort: " + child1.toString());
		
    }
}
