import java.util.*;

public class SortedSetDemo {

	public static void main(String[] args) {
		SortedSet<String> dr = new TreeSet<String>();
		dr.add("dgdfgd");
		dr.add("mdgdfk");
		dr.add("gfdgdfv");
		dr.add("khdfgdf");
		System.out.println("dr:");
		for (String s : dr) {
			System.out.println(s);
		}
	}
}
/*
 * Comparable and comparator: ===========================
 * 
 * 1)allows the comparing of the elements in the collections 2)few Collections
 * have a built in sort feature[ eg. SortedSet, SortedMaps] Others have
 * utilities methods for sorting[Collection.sort(List a)] 3)Comparator is
 * implemented in a separate class. eg: if model class is a 'Product'
 * 
 * to make it comparable: public class Product implements Comparator<Product>{
 * .... public int copmpareTo(Product target){ ... } }
 * 
 * But for comparator :-- public class CompareByNmae implements
 * Comparator<Product>{ public int compare(Product p1, Product p2){ ... } }
 *
 * Both compare() amd compareTo() return "int" where, value ZERO means contents
 * of the both objects are same and value POSITIVE NUMBER means contents of
 * FIRST objects is bigger and value NEGATIVE NUMBER means contents of FIRST
 * objects is smaller
 */