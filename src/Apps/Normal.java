package Apps;
public class Normal extends Car {
	
	private final double INITPERCENT = 0.020;
	private double engine = 99.0;
	private double total = 0.0;
	
	public Normal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Normal(String name, String brand) {
		super(name, brand);
		// TODO Auto-generated constructor stub
	}

	public double calculateTotal() {
		Normal norm = new Normal();
		double temp = (norm.getMarketPrice()*INITPERCENT)+norm.getLocation()+norm.engine+norm.getCoverage();
		norm.total = temp - (norm.getDiscount()/100)*temp;
		return norm.total;
	}

}
