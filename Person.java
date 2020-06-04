package nyu.edu.cs.cs102.ask662.crs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Person {

	 String firstName;
	 String lastName;
	 String fullName = firstName + " " + lastName;
	 int SSN;
	 int fatherSSN;
	 int motherSSN;
	 ArrayList<Integer> myFriends = new ArrayList<>();
	 
//fields of a person

	public Person(String fullName, int SSN, int fatherSSN, int motherSSN, ArrayList<Integer> myFriends) {
		this.fullName = fullName;
		this.fatherSSN = fatherSSN;
		this.motherSSN = motherSSN;
		this.myFriends = myFriends;
		
	}
	//create the person and fields that go in a person



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getSSN() {
		return SSN;
	}



	public void setSSN(int sSN) {
		SSN = sSN;
	}



	public int getFatherSSN() {
		return fatherSSN;
	}



	public void setFatherSSN(int fatherSSN) {
		this.fatherSSN = fatherSSN;
	}



	public int getMotherSSN() {
		return motherSSN;
	}



	public void setMotherSSN(int motherSSN) {
		this.motherSSN = motherSSN;
	}



	public ArrayList<Integer> getMyFriends() {
		return myFriends;
	}
//getters and setters for peeople characteristics


	
	
	/**public boolean isYourFriend(int SSN) {
		SSN.getMyFriends()
		for (int i = 0; i < myFriends.size(); i++) {
			if (i == SSN)
			{
				return true;
			}
			else {
				return false;
				
			}
		}
	}**/



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	



	public void setMyFriends(ArrayList<Integer> myFriends) {
		this.myFriends = myFriends;
	}
	
	 
	
}
