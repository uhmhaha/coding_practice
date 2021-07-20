package searchCodingTst.jickbang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Third {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int personNum = Integer.parseInt(input[0]);
		int comingInfo = Integer.parseInt(input[1]);
		int result[] ;
		LinkedList<Person> personlist = new LinkedList<Person>();

		for (int i = 1; i <= personNum; i++) {
			personlist.offer(new Person(i));
		}
		String[] timeline = br.readLine().split(" ");

		for (int j = 0; j < timeline.length; j++) {
			setContactInfo(personlist, timeline[j]);
		}
		int confirmed = br.readLine().charAt(0) - '0';
		
		for( Person p : personlist ) {
			if(p.id == confirmed) {
				for(Person cp : p.contactor )
					System.out.print(cp.id + " ");
				break;
			}
		}
	}

	public static void setContactInfo(LinkedList<Person> persons, String cp) {
		int cpId = Integer.parseInt(cp);
		// set isIs true
		if (cpId > 0) {
			for (Person p : persons) {
				if (p.id == cpId) {
					p.isIn = true;
					break;
				}
			}
			setContactor( persons, cpId);
		} else {
			for (Person p : persons) {
				if (p.id == cpId*(-1)) {
					p.isIn = false;
					break;
				}
			}
		}

	}
	
	public static void setContactor(LinkedList<Person> persons, int cpId) {
		// set contactor
		for (Person p : persons) {
			if (p.isIn == true && p.id != cpId) {
				p.contactor.offer(new Person(cpId));
			}
		}
		
		for (Person p : persons) {
			if (p.id == cpId) {
				for( Person pl : persons ) {
					if( pl.isIn == true && pl.id != cpId)
						p.contactor.offer(new Person(pl.id));
				}
					
			}
		}
	}

}

class Person implements Comparable<Person> {
	int id;
	PriorityQueue<Person> contactor;
	boolean isIn;

	Person(int id) {
		this.id = id;
		this.contactor = new PriorityQueue<Person>();
		this.isIn = false;
	}

	@Override
	public int compareTo(Person p) {
		return this.id > p.id ? 1 : -1;
	}
}
