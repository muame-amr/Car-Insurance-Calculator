package Apps;
public class Car {
	private static String name = " ";
	private static String brand = " ";
	private static double coverage = 0.0;
	private static double marketPrice = 0.0;
	private static double location = 0.0;
	private static double discount = 0.0;
	private java.util.Date dateCreated;
	
	protected Car() {
		this(name,brand);
		dateCreated = new java.util.Date();
	}
	
	protected Car(String name,String brand) {
		Car.name = name;
		Car.brand = brand;
		dateCreated = new java.util.Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Car.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		Car.brand = brand;
	}
	
	public static void setMarketPrice(double m) {
		Car.marketPrice = m;
	}

	public static void setDiscount(double d) {
		Car.discount = d;
	}

	public static void setAll(double c, double l) {
		Car.coverage = c;
		Car.location = l;
	}

	public static double getMarketPrice() {
		return marketPrice;
	}

	public static double getLocation() {
		return location;
	}

	public static double getDiscount() {
		return discount;
	}
	
	public static double getCoverage() {
		return coverage;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", brand=" + brand + ", dateCreated=" + dateCreated + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Car))
			return false;
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
