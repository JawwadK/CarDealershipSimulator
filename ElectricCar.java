/*
 * Name: Jawwad Khan
 * Date: March 18, 2019
 * Student ID: 500895949
 * Section: 031
 */
public class ElectricCar extends Car {
	// Instanced variables
	private int rechargeTime;
	private String batteryType;
	/**
	 * Default constructor for class ElectricCar
	 * @param mfr
	 * @param color
	 * @param power
	 * @param numWheels
	 * @param model
	 * @param maxRange
	 * @param safetyRating
	 * @param price
	 * @param awdVal
	 * @param rechargeTime
	 * @param batteryType
	 */
	public ElectricCar (String mfr, String color, int power, int numWheels, int model, int maxRange, double safetyRating, double price, boolean awdVal, int rechargeTime, String batteryType) {
			super(mfr, color, power, numWheels, model, maxRange, safetyRating, price, awdVal);
			this.rechargeTime = rechargeTime;
			this.setBatteryType(batteryType);
	}
	/**
	 * Returns recharge time of electric car
	 * @return rechargeTime
	 */
	public int getRechargeTime() {
		return rechargeTime;
	}
	/**
	 * Sets recharge time
	 * @param rechargeTime to set
	 */
	public void setRechargeTime(int rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	/**
	 * Returns battery type of electric car
	 * @return batteryType
	 */
	public String getBatteryType() {
		return batteryType;
	}
	/**
	 * Sets battery type
	 * @param batteryType
	 */
	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}
	/**
	 * Displays the electric car's details
	 * @return ElectricCar specs
	 */
	public String display() {
		return String.format("%s %-3d %-5s", super.display(), rechargeTime, batteryType);
	}
}