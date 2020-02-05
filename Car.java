/*
 * Name: Jawwad Khan
 * Date: March 18, 2019
 * Student ID: 500895949
 * Section: 031
 */
public class Car extends Vehicle implements Comparable<Car> {
	
	// Instances
	private int model;
	private int maxRange;
	private double safetyRating, price;
	private boolean AWD;
	private String modelStr;
	// Constants
	public static final int SEDAN = 0;
	public static final int SUV = 1;
	public static final int SPORTS = 2;
	public static final int MINIVAN = 3;
	/**
	 * Default constructor for class Car
	 * @param mfr
	 * @param color
	 * @param power
	 * @param numWheels
	 * @param model
	 * @param maxRange
	 * @param safetyRating
	 * @param price
	 * @param awdVal
	 */
	public Car (String mfr, String color, int power, int numWheels, int model, int maxRange, double safetyRating, double price, boolean awdVal) {
		super(mfr, color, power, numWheels);
		this.model = model;
		this.maxRange = maxRange;
		this.safetyRating = safetyRating;
		this.price = price;
		this.setAWD(awdVal);
	}
	/**
	 * Returns model of the car
	 * @return model
	 */
	public int getModel() {
		return model;
	}
	/**
	 * Sets model
	 * @param model
	 */
	public void setModel(int model) {
		this.model = model;
	}
	/**
	 * Returns max range of car
	 * @return maxRange
	 */
	public int getMaxRange() {
		return maxRange;
	}
	/**
	 * Sets max range
	 * @param maxRange
	 */
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}
	/**
	 * Returns safety rating of car
	 * @return safetyRating
	 */
	public double getSafetyRating() {
		return safetyRating;
	}
	/**
	 * Sets safety rating
	 * @param safetyRating
	 */
	public void setSafetyRating(double safetyRating) {
		this.safetyRating = safetyRating;
	}
	/**
	 * Returns the price of car
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Sets price
	 * @param price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Returns true if car AWD, else returns false
	 * @return AWD
	 */
	public boolean isAWD() {
		return AWD;
	}
	/**
	 * Sets the AWD boolean
	 * @param awd to set
	 */
	public void setAWD(boolean awd) {
		this.AWD = awd;
	}
	/**
	 * Checks if two Car objects equal
	 * @return equality
	 */
	public boolean equals(Object other) {
		Car otherCar = (Car) other;
		return super.equals(otherCar) && this.model == otherCar.model && (this.AWD == otherCar.AWD);
	}
	/**
	 * Compare two Car objects(overrides comparable interface method)
	 * @return comparision
	 */
	public int compareTo(Car other) {
		return new Double(this.price).compareTo(other.price);
	}
	/**
	 * Converts model from int to string
	 * @param model
	 * @return modelStr
	 */
	public String convertModelToString(int model) {
		switch (model) { //switches are easier and faster to do than multiple if statements
			case Car.SEDAN:
				modelStr = "SEDAN";
				break;
			case Car.SUV:
				modelStr = "SUV";
				break;
			case Car.SPORTS:
				modelStr = "SPORTS";
				break;
			case Car.MINIVAN:
				modelStr = "MINIVAN";
				break;
			default:
				break;
		}
		return modelStr;
	}
	/**
	 * Converts AWD from int to respective String value
	 * @param awd
	 * @return AWD or 2WD as string value
	 */
	public String checkAWD(boolean awdVal) {
		if (awdVal) return "AWD";
		else return "2WD";
	}

	/**
	 * Displays the car's details
	 * @return Car object specs
	 */
	public String display() {
		return String.format("%s %-8s %-5d %-8.2f %-10.2f %-5s", super.display(), convertModelToString(model), maxRange, safetyRating, price, checkAWD(AWD));
	}
}