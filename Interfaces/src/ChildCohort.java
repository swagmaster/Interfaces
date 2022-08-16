
/*
 * ChildCohort class takes in a list of children (or YoungHuman objects)
 * by adding or removing the YoungHumans to the ArrayList.
 */
public class ChildCohort extends ArrayList<YoungHuman>{
	
	//data member arraylist of younghumans
	ArrayList<YoungHuman> listOfChildren = new ArrayList<YoungHuman>();
	
	public ChildCohort() {
		
	}

	/*
	 * addAChild() adds the YoungHuman object to the arraylist.
	 */
	public void addAChild(YoungHuman other){
		if(other != null){
		    listOfChildren.insert(other, getIndex());
		} else {
		    System.out.println("Child is not valid.");
		}
		
	}
	
	/*
	 * removeAChild() removes the YoungHuman object from the front of the 
	 * arraylist.
	 */
	public void removeAChild(YoungHuman other){
		if(other == null || other.hasHadCheckUp() == false){
		    System.out.println("Cannot remove child for invalid check up.");
		}else {
		    listOfChildren.remove();
		}
	    
	}
	
	
}
