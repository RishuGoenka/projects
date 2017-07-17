import java.util.*;

public class Application {

	public static void main(String[] args) {

		List<Product> myProduct = new ArrayList<Product>();

		// name,description,prize
		myProduct.add(new Product("green tea", "good for health", 500));
		myProduct.add(new Product("coffee", "effective work", 250));
		myProduct.add(new Product("organic drink", "healthy", 725));

		System.out.println("OriginalList");
		print(myProduct);

		System.out.println("SortedList using name field");
		Collections.sort(myProduct, new NameComparator());
		print(myProduct);

		System.out.println("SortedList using price field");
		Collections.sort(myProduct, new PriceComparator());
		print(myProduct);

	}

	static void print(List<Product> product) {
		for (Product p : product) {
			System.out.println("Name : " + p.getName() + ", Price : " + p.getPrice());
		}

	}
}