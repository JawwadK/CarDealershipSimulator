/*
 * Name: Jawwad Khan
 * Date: March 18, 2019
 * Student ID: 500895949
 * Section: 031
 */
import java.util.*; //imports all libraries from java.util that will be needed in program(arraylist etc.)
public class CarDealership {
	// Instanced variables
	private ArrayList<Car> cars;
	private double minPrice, maxPrice;
	private boolean AWD, electric, price;
	public boolean isEmpty;
	public Car lastCar;
	// Comparator class for safety rating
	class SfRComparator implements Comparator<Car> {
		/**
		 * Compares two Car objects
		 * @param car1
		 * @param car2
		 * @return int value of result
		 */
		public int compare(Car car1, Car car2) {
			if (car1.getSafetyRating() < car2.getSafetyRating()) return -1;
			if (car1.getSafetyRating() > car1.getSafetyRating()) return 1;
			return 0;
		}
	}
	// Comparator class for max range
	class MxRngComparator implements Comparator<Car> {
		/**
		 * Compares two Car objects
		 * @param car1
		 * @param car2
		 * @return int value of result
		 */
		public int compare(Car car1, Car car2) {
			if (car1.getMaxRange() < car2.getMaxRange()) return -1;
			if (car1.getMaxRange() > car1.getMaxRange()) return 1;
			return 0;
		}
	}
	// Default constructor for CarDealership
	public CarDealership () {
		cars = new ArrayList<Car>();
		this.isEmpty = true;
	}
	/**
	 * Adds cars from an array list
	 * @param newCars ArrayList of Car objects
	 */
	public void addCars(ArrayList<Car> newCars) {
		if (newCars.size() > 0) {
			cars.addAll(newCars);
			this.isEmpty = false;
		}

		else{throw new IndexOutOfBoundsException("\nERROR: No cars can be added since arraylist empty.");} 	// Throws exception when array list is empty
	}
	/**
	 * Buys a car (removes from array list) given car index position, updates lastCar object with bought car
	 * @param index specified
	 * @return lastCar
	 */
	public Car buyCar(int index) {
		if (index < cars.size()) {
			lastCar = cars.get(index);
			cars.remove(index);
			if (cars.size() <= 0)
				this.isEmpty = true;
			return lastCar;
		}
		return null;
	}
	/**
	 * Returns last bought car (adds car back to end array list)
	 * @param car to return
	 */
	public void returnCar(Car car) {
		if (car != null) {
			cars.add(car);
			this.isEmpty = false;
			lastCar = null;
		}
		// Throws an exception when last car bought is null(no buy function used before)
		else{throw new IllegalArgumentException("\nERROR: Can't find car to return.");}
	}
	// Displays inventory of cars
	public void displayInventory() {
		for (int i = 0; i < cars.size(); i++) {
			Car currentCar = cars.get(i);
			String output = String.format("%-6d %s", i, currentCar.display());
			// Various different combinations of filters for a total of 8 different ways to filter list(including not filtering it)
			if (electric && AWD && price) {
				if (currentCar.getPower() == Car.ELECTRIC_MOTOR && currentCar.isAWD() && currentCar.getPrice() >= minPrice && currentCar.getPrice() <= maxPrice)
					System.out.println(output);
			}
			else if (electric && price) {
				if (currentCar.getPower() == Car.ELECTRIC_MOTOR && currentCar.getPrice() >= minPrice && currentCar.getPrice() <= maxPrice)
					System.out.println(output);
			}
			else if (AWD && price) {
				if (currentCar.isAWD() && currentCar.getPrice() >= minPrice && currentCar.getPrice() <= maxPrice)
					System.out.println(output);
			}
			else if (electric && AWD) {
				if(currentCar.getPower() == Car.ELECTRIC_MOTOR && currentCar.isAWD())
					System.out.println(output);
			}
			else if (electric) {
				if(currentCar.getPower() == Car.ELECTRIC_MOTOR)
					System.out.println(output);
			}
			else if (AWD) {
				if(currentCar.isAWD())
					System.out.println(output);
			}
			else if (price) {
				if(currentCar.getPrice() >= minPrice && currentCar.getPrice() <= maxPrice)
					System.out.println(output);
			}
			else
				System.out.println(output);
		}
	}
	// Filters vehicles to only electric cars
	public void filterByElectric() {
		this.electric = true;
	}
	// Filters vehicles to only AWD
	public void filterByAWD() {
		this.AWD = true;
	}
	/**
	 * Filters vehicles by price to range between minimum and maximum (inclusive)
	 * @param minPrice
	 * @param maxPrice
	 */
	public void filterByPrice(double minPrice, double maxPrice) {
		this.price = true;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	// Clears filters (sets all filters to false)
	public void FiltersClear() {
		this.AWD = false;
		this.electric = false;
		this.price = false;
		this.minPrice = Integer.MIN_VALUE;
		this.maxPrice = Integer.MAX_VALUE;
	}
	// Sorts array list by price(ascending)
	public void sortByPrice() {
		Collections.sort(cars);
	}
	// Sorts array list by safety rating(ascending)
	public void sortBySafetyRating() {
		Collections.sort(cars, new SfRComparator());
	}
	// Sorts array list by max range(ascending)
	public void sortByMaxRange() {
		Collections.sort(cars, new MxRngComparator());
	}
}