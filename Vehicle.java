/*
 * Name: Jawwad Khan
 * Date: March 18, 2019
 * Student ID: 500895949
 * Section: 031
 */
public class Vehicle {
	// Instanced variables
	private String mfr, color, powerString;
	private int power, numWheels;
	// Constants
	public static final int ELECTRIC_MOTOR = 0;
	public static final int GAS_ENGINE = 1;
	/**
	 * Default constructor for class Vehicle
	 * @param mfr
	 * @param color
	 * @param power
	 * @param numWheels
	 */
	public Vehicle (String mfr, String color, int power, int numWheels) {
		this.mfr = mfr;
		this.color = color;
		this.power = power;
		this.numWheels = numWheels;
	}
	/**
	 * Returns manufacturer of vehicle
	 * @return mfr
	 */
	public String getMfr() {
		return mfr;
	}
	/**
	 * Sets manufacturer 
	 * @param mfr
	 */
	public void setMfr(String mfr) {
		this.mfr = mfr;
	}
	/**
	 * Returns color of vehicle
	 * @return color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Sets color of vehicle
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * Returns the power type of vehicle
	 * @return power
	 */
	public int getPower() {
		return power;
	}
	/**
	 * Sets power type of vehicle
	 * @param power 
	 */
	public void setPower(int power) {
		this.power = power;
	}
	/**
	 * Returns number of wheels Vehicle has
	 * @return numWheels
	 */
	public int getNumWheels() {
		return numWheels;
	}
	/**
	 * Sets number of wheels
	 * @param numWheels
	 */
	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}
	/**
	 * Converts the power type from an integer to its respective String value
	 * @param power
	 * @return powerString
	 */
	public String convertPowertoString(int power) {
		switch (power) {
			case Car.ELECTRIC_MOTOR:
				powerString = "ELECTRIC_MOTOR";
				break;
			case Car.GAS_ENGINE:
				powerString = "GAS_ENGINE";
				break;
			default:
				powerString = null;
				break;
		}
		return powerString;
	}
	/**
	 * Checks if two Vehicle objects are equal
	 * @return the equality
	 */
	public boolean equals(Object other) {
		Vehicle otherVehicle = (Vehicle) other;
		return (this.mfr.equals(otherVehicle.mfr)) && (this.power == otherVehicle.power) && (this.numWheels == otherVehicle.numWheels);
	}
	/** 
	 * Displays vehicle's manufacturer and color
	 * @return vehicle mfr and color
	 */
	public String display() {
		return String.format("%-11s %-6s", mfr, color);
	}
}