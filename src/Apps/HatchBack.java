package Apps;
public class HatchBack extends Car{

	private final double INITPERCENT = 0.025;
	private double engine = 132.00;
	private double total = 0.0;
	
	public HatchBack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HatchBack(String name, String brand) {
		super(name, brand);
		// TODO Auto-generated constructor stub
	}

	public double calculateTotal() {
		HatchBack hb = new HatchBack();
		double temp = (hb.getMarketPrice()*INITPERCENT)+hb.getLocation()+hb.engine+hb.getCoverage();
		hb.total = temp - (hb.getDiscount()/100)*temp;
		return hb.total;
	}
}
