package nyu.edu.cs.cs102.ask662.crs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		// create tree
		Tree<Person> people = new Tree<Person>();
		// LinkedList people = new LinkedList();
		String file = "communityfile.txt";
		// should this be courses.ser??
		File f = new File(file);
		String filef = "queriesfile.txt";
		File h = new File(filef);
		// same implementation as hw 1!! hhahaha
		// do i need the above statements, did this in hw 1??
//read in ppl and create ppl objects w their qualities
		try { // do i need try catch block??
			Scanner scan = new Scanner(new File("communityfile.txt"));
			while (scan.hasNextLine()) {
				String[] myBuffer;
				// scan.nextLine();
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					if (!line.isEmpty()) {
						String[] a = line.split(":");
						String firstname = a[1].trim();
						line = scan.nextLine();
						String[] b = line.split(":");
						String lastname = b[1].trim();
						String fullname = firstname + " " + lastname;
						line = scan.nextLine();
						String[] c = line.split(":");
						// String[] c = line.split("\\s+");
						int ssn = Integer.parseInt(c[1].trim());
						line = scan.nextLine();
						String[] d = line.split(":");
						// System.out.println(Arrays.toString(d));
						int dad = Integer.parseInt(d[1].trim());
						line = scan.nextLine();
						String[] e = line.split(":");
						int mom = Integer.parseInt(e[1].trim());
						ArrayList<Integer> friends = new ArrayList<>();
						line = scan.nextLine();
						String[] ff = line.split(":");
						String[] g = ff[1].split(",");
						for (int i = 0; i < g.length; i++) {
							String friend = g[i].trim();
							int friendss = Integer.parseInt(g[i].trim());
							friends.add(friendss);
						}
						//add ppl to the tree
						Person p = new Person(fullname, ssn, dad, mom, friends);
						// System.out.println(String.format("Person%s\tMom%d\tDad%d", p.fullName,
						// p.motherSSN, p.fatherSSN));
						people.insert(ssn, p);

					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("This file does not exist!");
			// might not be true..............
		}

		try { // do i need try catch block?
			//now, read in queries file, and call methods on it
			//depending on whaht its asking and what node its asking about
			Scanner scn = new Scanner(new File("queriesfile.txt"));
			ArrayList<String> questions = new ArrayList<String>();
			while (scn.hasNextLine()) {
				String fullLine = scn.nextLine().trim();
				String lne = fullLine;
				int num = -1;
				int spaceIndex = fullLine.indexOf(" ");
				if (spaceIndex != -1) {
					lne = fullLine.substring(0, spaceIndex);
					num = Integer.parseInt(fullLine.substring(spaceIndex + 1));
				}
//				int num = Integer.parseInt(scn.next().trim());
				//so, we understand and implement the question 
				questions.add(lne);
				//lne = scanner.next;
				//make sure it ignores case
				//call method on that node
				///if no answer, print unavilable
				//if answer, print answer in correct format
				if (lne.equalsIgnoreCase("NAME-OF")) {
					//String[] j = lne.split(" ");
//					int numba = Integer.parseInt(scn.next().trim());
					System.out.println("NAME-OF " + num + ": " + getName(num, people));
				} else if (lne.equalsIgnoreCase("FATHER-OF")) {
					//String[] k = lne.split(" ");
//					int numbar = Integer.parseInt(scn.next().trim());
					// System.out.println(numbar);
					System.out.println("FATHER-OF " + num + ": " + getFatherName(num, people));
				} else if (lne.equalsIgnoreCase("MOTHER-OF")) {
					//String[] L = lne.split(" ");
//					int numbarr = Integer.parseInt(scn.next().trim());
					System.out.println("MOTHER-OF " + num + ": " + getMotherName(num, people));
					// add these strings to the
				} else if (lne.equalsIgnoreCase("HALF-SIBLINGS-OF")) {
					//String[] M = lne.split(" ");
		//			int numberr = Integer.parseInt(scn.next().trim());
					String halfSiblings = getHalfSiblings(num, people, people.getRoot());
					halfSiblings = halfSiblings.replaceAll("//s+", "");
					if (halfSiblings.equals(""))
						System.out.println("HALF-SIBLINGS-OF " + num + ": " + "UNAVAILABLE");
					else
						System.out.println("HALF-SIBLINGS-OF " + num + ": " + halfSiblings);
				}
				else if (lne.equalsIgnoreCase("FULL-SIBLINGS-OF")) {
					//String[] N = lne.split(" ");
					//int numberry = Integer.parseInt(scn.next().trim());
					String fullSiblings = getFullSiblings(num, people, people.getRoot());
					fullSiblings = fullSiblings.replaceAll("//s+", "");
					fullSiblings = fullSiblings.replace(people.find(num).getData().getFullName(), "");
					if (fullSiblings.equals("")) {
						System.out.println("FULL-SIBLINGS-OF " + num + ": " + "UNAVAILABLE");
					}
					else {
						System.out.println("FULL-SIBLINGS-OF " + num + ": " + fullSiblings);
					}
				} else if (lne.equalsIgnoreCase("CHILDREN-OF")) {
					//String[] O = lne.split(" ");
					//int numberrr = Integer.parseInt(scn.next().trim());
					String children = getChildren(num, people, people.getRoot());
					children = children.replaceAll("//s+", "");
					if (children.equals(""))
						System.out.println("CHILDREN-OF " + num + ": " + "UNAVAILABLE");
					else
						System.out.println("CHILDREN-OF " + num + ": " + children);
				} else if (lne.equalsIgnoreCase("MUTUAL-FRIENDS-OF")) {
					//String[] P = lne.split(" ");
					//int numbe = Integer.parseInt(scn.next().trim());
					ArrayList<String> mutuals = findMutualFriends(num, people);
					if (mutuals.size() == 0) {
						System.out.println("MUTUAL-FRIENDS-OF " + num + ": " + "UNAVAILABLE");
					} else {
						System.out.println("MUTUAL-FRIENDS-OF " + num + ": ");
						for (int i = 0; i < mutuals.size(); i++) {
							System.out.println(mutuals.get(i) + "");
						}
					}
				} else if (lne.equalsIgnoreCase("INVERSE-FRIENDS-OF")) {
					//String[] Q = lne.split(" ");
					//int numbee = Integer.parseInt(scn.next().trim());
					String inverse = findInverseFriends(num, people, people.getRoot());
					inverse = inverse.replaceAll("//s+", "");
					if (inverse.equals("")) {
						System.out.println("INVERSE-FRIENDS-OF " + num + ": " + "UNAVAILABLE");
					}
					else {
						System.out.println("INVERSE-FRIENDS-OF " + num + ": " + inverse);
					}
				} else if (lne.equalsIgnoreCase("WHO-HAS-MOST-MUTUAL-FRIENDS")) {
					String mostMutuals = findMostMutualFriends(people);
					if (mostMutuals == "") {
						System.out.println("MOST MUTUAL FRIENDS UNAVILABLE");
					} else
						System.out.println("WHO-HAS-MOST-MUTUAL-FRIENDS: " + mostMutuals);
				}
				

			}

		} catch (FileNotFoundException e) {
			System.out.println("This file does not exist!");
			// might not be true either................
		}

		/**
		 * System.out.println("NAME-OF 1 " + getName(1, people));
		 * System.out.println("FATHER-OF 10 " + getFatherName(10, people));
		 * System.out.println("MOTHER-OF 10 " + getMotherName(10, people));
		 * System.out.println("MOTHER-OF 11 " + getMotherName(11, people));
		 * System.out.println("HALF-SIBLINGS-OF 11 " + getHalfSiblings(11, people,
		 * people.getRoot())); System.out.println("FULL-SIBLINGS-OF 1 "+
		 * getFullSiblings(1, people, people.getRoot()));
		 * System.out.println("CHILDREN-OF 5 " + getChildren(5, people,
		 * people.getRoot())); System.out.println("CHILDREN-OF 1 " + getChildren(1,
		 * people, people.getRoot())); System.out.println("MUTUAL-FRIENDS-OF 5 " +
		 * findMutualFriends(5, people, people.getRoot()));
		 * System.out.println("INVERSE-FRIENDS-OF 9 " + findInverseFriends(9, people,
		 * people.getRoot() )); System.out.println("WHO-HAS-MOST-MUTUAL-FRIENDS " +
		 * findMostMutualFriends(null, people, people.getRoot() ));
		 **/

	}

	public static String getName(int ssn, Tree<Person> people) {
		Node<Person> person = people.find(ssn);
		String myName = person.data.getFullName();
		//String fullName = people.find(ssn).getData().getFullName();
		if (person != null) {
			return myName;
		}
		else {
			return "";
		}
		//handle if person doesnt exist
		// will they be on separate lines??
		//get someones name- easy
	}

	public static String getFatherName(int ssn, Tree<Person> people) {
		Node<Person> p = people.find(ssn);
		// System.out.println("Person: " + p.data.getFullName());
		int fatherSSN = p.data.getFatherSSN();
		// int fatherSSN = people.find(ssn).getData().getFatherSSN();
		// System.out.println("father SSN " + fatherSSN);
		// on that node, call the fathers name
		Node<Person> father = people.find(fatherSSN);
		if (father != null)
			return ((Person) father.getData()).getFullName();
		else
			return "";

	}

	public static String getMotherName(int ssn, Tree<Person> people) {
		Node<Person> p = people.find(ssn);
		int motherSSN = p.data.getMotherSSN();
		// on that node, call
		Node<Person> mother = people.find(motherSSN);
		//String fullName = people.find(motherSSN).getData().getFullName();
		if (mother != null) {
			return ((Person) mother.getData()).getFullName();
		}
		else {
			
		return "";
		}
		//handle if mother doesnt exist
		// will they be on separate lines??
	}

	public static String getHalfSiblings(int ssn, Tree<Person> people, Node<Person> localRoot) {
		int motherSSN = people.find(ssn).getData().getMotherSSN();
		int fatherSSN = people.find(ssn).getData().getFatherSSN();
		// System.out.println("method call");
		String halfSiblings = "";
		if (localRoot != null) {
			// System.out.println("recursing");
			halfSiblings += getHalfSiblings(ssn, people, localRoot.leftChild);
			// System.out.println(String.format("motherA%d\t, fatherA%d\t, motherB%d\t,
			// fatherB%d\t",motherSSN, fatherSSN,
			// localRoot.getData().getMotherSSN(), localRoot.getData().getFatherSSN()));
			if ((localRoot.getData().getMotherSSN() == motherSSN && localRoot.getData().getFatherSSN() != fatherSSN)
					|| (localRoot.getData().getMotherSSN() != motherSSN
							&& localRoot.getData().getFatherSSN() == fatherSSN)) {
				//can only have the same father or mother- not both
				// System.out.println(localRoot.getData().getMotherSSN() + " " + motherSSN);
				// System.out.println(localRoot.getData().getFatherSSN() + " " + fatherSSN);
				halfSiblings += (" " + localRoot.getData().getFullName());
				// System.out.println("Current half-sibling: " + halfSiblings);
			}
			// System.out.print(localRoot.iData + " ");
			halfSiblings += getHalfSiblings(ssn, people, localRoot.rightChild);
		}
		// System.out.println(halfSiblings);
		// if (halfSiblings == "") {
		// System.out.println("UNAVAILABLE HALF SIBLING");
		// }
		return halfSiblings;
	}

	public static String getFullSiblings(int ssn, Tree<Person> people, Node<Person> localRoot) {
		int motherSSN = people.find(ssn).getData().getMotherSSN();
		int fatherSSN = people.find(ssn).getData().getFatherSSN();
		String fullSiblings = "";
		if (localRoot != null) {
			fullSiblings = getFullSiblings(ssn, people, localRoot.leftChild);
			if ((localRoot.getData().getMotherSSN() == motherSSN)
					&& (localRoot.getData().getFatherSSN() == fatherSSN)) {
				//has same father and mother
				// if (localRoot.getData().getSSN() != ssn) {
				// System.out.println(localRoot.getData().getSSN() + " " + ssn);
				fullSiblings += (" " + localRoot.getData().getFullName());

			}
			// System.out.print(localRoot.iData + " ");
			fullSiblings += getFullSiblings(ssn, people, localRoot.rightChild);
		}
		// System.out.println(fullSiblings);
		// if (fullSiblings == "") {
		// System.out.println("UNAVAILABLE FULL SIBLING");
		// fullSiblings -= (people.find(ssn).getData().getFullName()));
		// }
		return fullSiblings;
	}

	/**
	 * public String getFullSiblings(int ssn, Tree<Person> people, Node<Person>
	 * localRoot) { int motherSSN = people.find(ssn).getData().getMotherSSN(); int
	 * fatherSSN = people.find(ssn).getData().getFatherSSN(); if(localRoot != null)
	 * { getFullSiblings(localRoot.leftChild); //System.out.print(localRoot.iData +
	 * " "); inOrder(localRoot.rightChild); } }
	 * 
	 * if (ssn = motherSSN and ssn = fatherSSN) { subtract itself???? if none, print
	 * unavailable } }
	 **/

	public static String getChildren(int ssn, Tree<Person> people, Node<Person> localRoot) {

		String children = "";
		if (localRoot != null) {
			children = getChildren(ssn, people, localRoot.leftChild);
			if ((localRoot.getData().getMotherSSN() == ssn) || localRoot.getData().getFatherSSN() == ssn) {
				children += (" " + localRoot.getData().getFullName());
			}
			// System.out.print(localRoot.iData + " ");
			children += getChildren(ssn, people, localRoot.rightChild);
		}
		// System.out.println(children);
		// if (children == "") {
		//see who considers this node as a mom or dad cuz we dont know which they are
		// System.out.println("UNAVAILABLE CHILDREN");
		// }
		return children;
	}

	/**
	 * public String findChildren(int ssn) {
	 * 
	 * if(localRoot != null) { inOrder(localRoot.leftChild);
	 * //System.out.print(localRoot.iData + " "); inOrder(localRoot.rightChild); } }
	 * 
	 * for all, in order traverse if find(ssn).getData().getMotherSSN(); or
	 * find(ssn).getData().getFatherSSN();\ equals their ssn print out that nodes
	 * first and last name
	 * 
	 * 
	 * 
	 * }
	 **/
	// ArrayList<Integer> friends = new ArrayList<Integer>();\
	//i used a for loop here
	//went thru target persons friends, friends lists to see if target person was in there

	public static ArrayList<String> findMutualFriends(int ssn, Tree<Person> people) {
		//System.out.println("Finding mutual friends of " + ssn);
		ArrayList<String> pplz = new ArrayList<String>();
		Person target = people.find(ssn).getData();
		//System.out.println("Mutual friends are: " + target.getMyFriends().toString());
		for (int i = 0; i < target.getMyFriends().size(); i++) {
			//System.out.println("Searching friend: " + target.getMyFriends().get(i));
			Person current = people.find(target.getMyFriends().get(i)).getData();
			//System.out.println(current.getMyFriends().toString());
			if (current.getMyFriends().contains(ssn)) {
				pplz.add(current.getFullName());
				//add them to an array list
			}
		}
		//System.out.println("The mutual friends of " + ssn + " are " + pplz.toString());
		return pplz;
	}

	// for (int i = 1; i < people.size + 1; i++) {

	// Person current = people.find(i).getData();
	// if ((current.getMyFriends().contains(ssn))
	// && (target.getMyFriends().contains(current.getSSN()))) {

	// pplz.add(people.find(i).getData().getFullName());
	// }

	// }
	// return pplz;
	// }

	/**
	 * public static ArrayList<String> findMutualFriends(int ssn, Tree<Person>
	 * people, Node<Person> localRoot) { ArrayList<String> pplz = new
	 * ArrayList<String>(); //ArrayList<String> mtu //String mutuals = "";
	 * if(localRoot != null) { pplz.addAll(findMutualFriends(ssn, people,
	 * localRoot.leftChild)); if (localRoot.getData().getMyFriends().contains(ssn)
	 * &&
	 * (people.find(ssn).getData().getMyFriends().contains(localRoot.getData().getSSN())))
	 * { //mutuals += ( " " + localRoot.getData().getFullName());
	 * pplz.add(localRoot.getData().getFullName()); }
	 * //System.out.print(localRoot.iData + " "); pplz.addAll(findMutualFriends(ssn,
	 * people, localRoot.rightChild)); } // System.out.println(mutuals); // if
	 * (mutuals.equals("")) { // System.out.println("UNAVAILABLE MUTUAL FRIENDS");
	 * // } return pplz; } //For (people.find(ssn).getData.getFriends() :f){
	 * 
	 * /**} find each SSN, find person, this person's friends list
	 * 
	 * retrieve their friends list
	 * 
	 * //call method here!!! //print those names N.getFriends() for (myFriends : f)
	 * if (f.isMyFriend()) { f.getFullName(); }
	 **/
	//see who considers u a freind
	public static String findInverseFriends(int ssn, Tree<Person> people, Node<Person> localRoot) {
		// ArrayList<Integer> friends = new
		String inverse = "";
		if (localRoot != null) {
			inverse = findInverseFriends(ssn, people, localRoot.leftChild);
			if ((localRoot.getData().getMyFriends().contains(ssn))) {
				inverse += (" " + localRoot.getData().getFullName());
			}
			// System.out.print(localRoot.iData + " ");
			inverse += findInverseFriends(ssn, people, localRoot.rightChild);
		}
		return inverse;
	}

	/**
	 * public String findInverseFriends(int ssn) { inOrder traverse N.getFriends()
	 * for (Friends :f ) { if f == ssn and !f.ismyFriend(){ f.getFullName //won't
	 * this include mutual friends???? } }
	 * 
	 * } }
	 * 
	 * }
	 **/
	//call mutual friends method inside this method
	//see whose arraylist is longest
	//theyre the most popylar
	public static String findMostMutualFriends(Tree<Person> people) {
		String popular = "";
		int maxArray = 0;
		// ArrayList<String> mostMutuals = new ArrayList<String>();
		for (int i = 1; i < people.size + 1; i++) {
			ArrayList<String> mostMutualss = findMutualFriends(i, people);
			int size = mostMutualss.size();
			String popularr = people.find(i).getData().getFullName();
			if (size > maxArray) {

				maxArray = size;
				popular = popularr;
			}
		}
		return popular;
	}

	/**
	 * if
	 * ((people.find(i).getData().getMyFriends().contains(people.find(j).getData().getSSN()))
	 * &&
	 * (people.find(j).getData().getMyFriends().contains(people.find(i).getData().getSSN()))){
	 * mostMutuals.add(people.find(i).getData().fullName); } if (mostMutuals.size()
	 * > maxArray) { maxArray = mostMutuals.size(); popular =
	 * people.find(i).getData().getFullName(); }
	 * 
	 * } return popular; }
	 * 
	 * /** if(localRoot != null) {
	 * 
	 * /** mostMutuals = findMostMutualFriends(people, localRoot.leftChild); int
	 * frndz = findMutualFriends(localRoot.data.SSN, people,
	 * localRoot.leftChild).size(); mostMutuals.add(frndz); int frndzz =
	 * findMutualFriends(localRoot.data.SSN, people, localRoot.rightChild).size();
	 * mostMutuals.add(frndzz); //System.out.print(localRoot.iData + " ");
	 * mostMutuals = findMostMutualFriends(people, localRoot.rightChild); } return
	 * mostMutuals;
	 * 
	 * }
	 **/

}
