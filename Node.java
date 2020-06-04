package nyu.edu.cs.cs102.ask662.crs;

import java.util.ArrayList;
import java.util.Collections;

public class Node<T> {

	public T data;
	//public Node next;
	//public Node previous;
	public int iData;
	public Node<T> leftChild;
	public Node<T> rightChild;
	public double dData;
	private Node<T> previous;
	//public Node next;
	private Node<T> next;
	
	public Node() {
		
	}
	
	//constructor
	public void storePerson(T data) {
		//how to store person in node?
		this.data= data;
		
	}
	
	//getters and setters for generic ssn, person, left/right child
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getiData() {
		return iData;
	}
	public void setiData(int iData) {
		this.iData = iData;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public double getdData() {
		return dData;
	}
	public void setdData(double dData) {
		this.dData = dData;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	//getter/setter for next/previous
	
	/**
	public String getName(int ssn, Tree<Person> people) {
		String fullName = people.find(ssn).getData().getFullName();
		return fullName;
		
		//will they be on separate lines??
	}

	public String getFatherName(int ssn, Tree<Person> people) {
		int fatherSSN = people.find(ssn).getData().getFatherSSN();
		//on that node, call
		String fullName = people.find(fatherSSN).getData().getFullName();
		return fullName;
		
	}

	public String getMotherName(int ssn, Tree<Person> people) {
		int motherSSN = people.find(ssn).getData().getMotherSSN();
		//on that node, call
		String fullName = people.find(motherSSN).getData().getFullName();
		return fullName;
		
		//will they be on separate lines??
	}

	public String getHalfSiblings(int ssn, Tree<Person> people, Node<Person> localRoot) {
		int motherSSN = people.find(ssn).getData().getMotherSSN();
		int fatherSSN = people.find(ssn).getData().getFatherSSN();
		String halfSiblings = "";
	     if(localRoot != null)
	        {
	        halfSiblings = getHalfSiblings( ssn,  people, localRoot.leftChild);
	        if ((localRoot.getData().getMotherSSN() == motherSSN && localRoot.getData().getFatherSSN() != fatherSSN) || (localRoot.getData().getMotherSSN() != motherSSN && localRoot.getData().getFatherSSN() == fatherSSN)) {
	        	halfSiblings += ( " " + localRoot.getData().getFullName());
	        }
	        //System.out.print(localRoot.iData + " ");
	        halfSiblings = getHalfSiblings(ssn, people, localRoot.rightChild);
	        }
	     System.out.println(halfSiblings);
	     if (halfSiblings == "") {
	    	 System.out.println("UNAVAILABLE");
	     }
		return halfSiblings;	 
	     }
		
		
	public String getFullSiblings(int ssn, Tree<Person> people, Node<Person> localRoot) {
		int motherSSN = people.find(ssn).getData().getMotherSSN();
		int fatherSSN = people.find(ssn).getData().getFatherSSN();
		String fullSiblings = "";
	     if(localRoot != null)
	        {
	        fullSiblings = getFullSiblings( ssn,  people, localRoot.leftChild);
	        if ((localRoot.getData().getMotherSSN() == motherSSN) && localRoot.getData().getFatherSSN() == fatherSSN) {
	        	fullSiblings += ( " " + localRoot.getData().getFullName());
	        }
	        //System.out.print(localRoot.iData + " ");
	        fullSiblings = getFullSiblings(ssn,  people, localRoot.rightChild);
	        }
	     System.out.println(fullSiblings);
	     if (fullSiblings == "") {
	    	 System.out.println("UNAVAILABLE");
	     }
		return fullSiblings;	 
	     }

	/**public String getFullSiblings(int ssn, Tree<Person> people, Node<Person> localRoot) {
		int motherSSN = people.find(ssn).getData().getMotherSSN();
		int fatherSSN = people.find(ssn).getData().getFatherSSN();
	     if(localRoot != null)
	        {
	        getFullSiblings(localRoot.leftChild);
	        //System.out.print(localRoot.iData + " ");
	        inOrder(localRoot.rightChild);
	        }
	     }
		
		if (ssn = motherSSN and ssn = fatherSSN) { 
			subtract itself????
			if none, print unavailable
		}
	}**/

	public String getChildren(int ssn, Tree<Person> people, Node<Person> localRoot) {
		
		String children = "";
	     if(localRoot != null)
	        {
	        children = getChildren(ssn, people, localRoot.leftChild);
	        if ((localRoot.getData().getMotherSSN() == ssn) || localRoot.getData().getFatherSSN() == ssn) {
	        	children += ( " " + localRoot.getData().getFullName());
	        }
	        //System.out.print(localRoot.iData + " ");
	        children = getChildren(ssn, people, localRoot.rightChild);
	        }
	     System.out.println(children);
	     if (children == "") {
	    	 System.out.println("UNAVAILABLE");
	     }
		return children;	 
	     }

	/**public String findChildren(int ssn) {
		
	     if(localRoot != null)
	        {
	        inOrder(localRoot.leftChild);
	        //System.out.print(localRoot.iData + " ");
	        inOrder(localRoot.rightChild);
	        }
	     }
		
	for all, in order traverse
	if find(ssn).getData().getMotherSSN(); or find(ssn).getData().getFatherSSN();\
			equals their ssn
			print out that nodes first and last name
			

		
	}**/
	//ArrayList<Integer> friends = new ArrayList<Integer>();
/**
	public ArrayList<String> findMutualFriends(int ssn, Tree<Person> people, Node<Person> localRoot) {
		ArrayList<String> pplz = new ArrayList<String>();
		//ArrayList<String> mtu
		String mutuals = "";
		if(localRoot != null)
	    {
	    pplz = findMutualFriends(ssn, people, localRoot.leftChild);
	    /**if ((localRoot.getMotherSSN() == ssn || localRoot.getFatherSSN() == ssn) {
	    	children += ( " " + localRoot.getData().getFullName());
	    }**/
	
	/**
	    if (localRoot.getData().getMyFriends().contains(ssn) && (people.find(ssn).getData().getMyFriends().contains(localRoot.getData().getSSN()))) {
	    	mutuals += ( " " + localRoot.getData().getFullName());
	    	pplz.add(localRoot.getData().getFullName());
		}
	    //System.out.print(localRoot.iData + " ");
	    pplz = findMutualFriends(ssn, people, localRoot.rightChild);
	    }
	 System.out.println(mutuals);
	 if (mutuals == "") {
		 System.out.println("UNAVAILABLE");
	 }
	 return pplz;
	 }
		/**For (people.find(ssn).getData.getFriends() :f){
			
		}
		find each SSN, find person, this person's friends list
		
		retrieve their friends list
		
		//call method here!!!
		//print those names
		N.getFriends()
		for (myFriends : f)
			if (f.isMyFriend()) {
				f.getFullName();
			}**/
		
/**
	public String findInverseFriends(int ssn, Tree<Person> people, Node<Person> localRoot) {
		//ArrayList<Integer> friends = new
		String inverse = "";
		if(localRoot != null)
	    {
	    inverse = findInverseFriends(ssn, people, localRoot.leftChild);
	    /**if ((localRoot.getMotherSSN() == ssn || localRoot.getFatherSSN() == ssn) {
	    	children += ( " " + localRoot.getData().getFullName());
	    }**/
	/**
	    if ((localRoot.getData().getMyFriends().contains(ssn))){
	    	inverse += ( " " + localRoot.getData().getFullName());
		}
	    //System.out.print(localRoot.iData + " ");
	    inverse= findInverseFriends(ssn, people, localRoot.rightChild);
	    }
	 System.out.println(inverse);
	 if (inverse == "") {
		 System.out.println("UNAVAILABLE");
	 }
	return inverse;	 
	 }
	/**public String findInverseFriends(int ssn) {
		inOrder traverse
		N.getFriends()
		for (Friends :f ) {
			if f == ssn and !f.ismyFriend(){
				f.getFullName
				//won't this include mutual friends????
			}
		}
			
		}
	}
		
	}**/

	/**
	public ArrayList<Integer> findMostMutualFriends(int ssn, Tree<Person> people, Node<Person> localRoot) {
		/**int count = 0;
		Traverse
		for each node 
		for each mutual friend
		++;
				store them in array list
				call greatest on array list
				return
	}**/
	/**
	 * 
	 */
	/**
	ArrayList<Integer> mostMutuals = new ArrayList<Integer>();	
	 if(localRoot != null)
	    {
		 
	    
	    mostMutuals = findMostMutualFriends(ssn, people, localRoot.leftChild);
	    int frndz = findMutualFriends(ssn, people, localRoot.leftChild).size();
	    mostMutuals.add(frndz);
	    //System.out.print(localRoot.iData + " ");
	    findMostMutualFriends(ssn, people, localRoot.rightChild);
	    }
	 System.out.println(people.find(Collections.max(mostMutuals)).getData().getFullName());
	return mostMutuals; 
	 }**/
	
	


}

