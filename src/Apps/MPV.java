package Apps;
public class MPV extends Car {
	
	private final double INITPERCENT = 0.030;
	private double engine = 198.0;
	private double total = 0.0;
	
	public MPV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MPV(String name, String brand) {
		super(name, brand);
		// TODO Auto-generated constructor stub
	}

	public double calculateTotal() {
		MPV mpv = new MPV();
		double temp = (mpv.getMarketPrice()*INITPERCENT)+mpv.engine+mpv.getLocation()+mpv.getCoverage();
		mpv.total = temp - (mpv.getDiscount()/100)*temp;
		return mpv.total;
	}
}
