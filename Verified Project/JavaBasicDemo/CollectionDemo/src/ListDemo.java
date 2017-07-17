import java.util.*;

public class ListDemo {

	public static void main(String[] args) {
		Collection data = new LinkedList();
		data.add("Dharmendra");
		data.add("Jitendra");
		data.add("Jitendra");
		data.add("aaya");
		data.add("MMiss");
		data.add("prao");

		/*
		 * Iterator it = data.iterator(); //checks whether next element is
		 * available or not while(it.hasNext()){ System.out.println(it.next());
		 * }
		 */

		for (Object obj : data) { // internally uses iterator
			System.out.println(obj + " is a type of "
					+ obj.getClass().getName());
		}
	}

}
