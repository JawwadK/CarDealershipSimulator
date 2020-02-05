/*
 * Name: Jawwad Khan
 * Date: March 18, 2019
 * Student ID: 500895949
 * Section: 031
 */

import java.util.*;
import java.io.*;

public class CarDealershipSimulator
{
	public static void main(String[] args) throws IOException
	{
	CarDealership vroom = new CarDealership(); // Creates CarDealership object used to store data
	ArrayList<Car> cars = new ArrayList<Car>(); // Creates arraylist to transfer into cardealership
	final String titleTop = String.format("%-6s %-11s %-6s %-8s %-5s %-8s %-10s %-5s %-3s %-7s", "Number", "Brand", "Color", "Model", "MxR", "SafeRng", "Price", "Type", "RT", "Battery");
	String filename = "cars.txt";
	String line = "";
	String command = "";

	if(readFile(filename, cars)) {
		Scanner input = new Scanner(System.in); // Creates a scanner object for keyboard input
		System.out.println("********************************************************");
		System.out.println("\nCar Dealership.exe open and running.\n");
		System.out.println("\n---Welcome to Car Dealership Simulator---\n");
		System.out.println("********************************************************");
		System.out.print("\nType 'ADD' to start program:  ");
		while (input.hasNextLine()) { // While the scanner has another line
			try {
				line = input.nextLine();
				Scanner commandLine = new Scanner(line);  // Second scanner reads the line string
				command = commandLine.next();
				switch (command) { // Switch statement executes command based on string entered 
					case "L": // Displays inventory
						if (!commandLine.hasNext()) {
							if (!vroom.isEmpty) {
								System.out.println(titleTop);
								vroom.displayInventory();
								System.out.println("********************************************************");
								System.out.println("\nInventory loaded successfully.\n");
								System.out.println("********************************************************");
							}
							else{System.out.println("\nERROR: Inventory empty, please use ADD command first.");}
							break;
						}
						// Makes so that foreign command immediately stops program
						commandLine.close();
						throw new NoSuchElementException();
					case "Q": // Ends program
						if (!commandLine.hasNext()) {
							commandLine.close();
							System.out.println("\nProgram End");
							return;
						}
						commandLine.close();
						throw new NoSuchElementException();
					case "BUY": // Buys car at index position
						if (commandLine.hasNextInt()) { // Checks if index position is present
							int index = commandLine.nextInt();
							if (!commandLine.hasNext()) {
								Car currentCar = vroom.buyCar(index);
								if (currentCar != null) {
									System.out.println("\nCar Details:");
									System.out.println(titleTop);
									System.out.printf("%-6d %s\n", index, currentCar.display());
									System.out.println("\nCar at position " + index + " bought successfully.");
								}
								else{System.out.println("\nERROR: Invalid car selected");}
								break;
							}
							commandLine.close();
							throw new NoSuchElementException();
						}
						else{System.out.println("\nERROR: Invalid car position");}
						break;
					case "RET": // Returns last bought car
						if (!commandLine.hasNext()) {
							Car returnCar = vroom.lastCar;
							vroom.returnCar(returnCar);
							System.out.println("\nReturned last bought car to inventory.");
							break;
						}
						commandLine.close();
						throw new NoSuchElementException();
					case "ADD": // Adds cars from arraylist to CarDealership object
						if (!commandLine.hasNext()) {
							vroom.addCars(cars);
							System.out.println("\nTransferred cars to dealership inventory.");
							break;
						}
						commandLine.close();
						throw new NoSuchElementException();
					case "SPR":  // Sorts by price in ascending order
						if (!commandLine.hasNext()) {
							if (!vroom.isEmpty) {
								vroom.sortByPrice();
								System.out.println("\nInventory sorted by price.");
							}
							else{System.out.println("\nERROR: Inventory empty, please use ADD command first.");}
							break;
						}
						commandLine.close();
						throw new NoSuchElementException();
					case "SSR": // Sorts by safety rating in ascending order
						if (!commandLine.hasNext()) {
							if (!vroom.isEmpty) {
								vroom.sortBySafetyRating();
								System.out.println("\nInventory sorted by safety rating.");
							}
							else{System.out.println("\nERROR: Inventory empty, please use ADD command first.");}
							break;
						}
						commandLine.close();
						throw new NoSuchElementException();
					case "SMR": // Sorts by max range(ascending)
						if (!commandLine.hasNext()) {
							if (!vroom.isEmpty) {
								vroom.sortByMaxRange();
								System.out.println("\nInventory sorted by max range.");
							}
							else{System.out.println("\nERROR: Inventory empty, please use ADD command first.");}
							break;
						}
						commandLine.close();
						throw new NoSuchElementException();
					case "FPR": //Filters list based on max and min price
						if (commandLine.hasNextInt()) { // Checks for first integer after 'FPR'
							int minPrice = commandLine.nextInt();
							if (commandLine.hasNextInt()) { // Checks for second integer after 'FPR'
								int maxPrice = commandLine.nextInt();
								if (!commandLine.hasNext()) {
									if (!vroom.isEmpty) {
										vroom.filterByPrice(minPrice, maxPrice);
										System.out.println("\nInventory filtered by price between $" + minPrice + " and $" + maxPrice + ".");
									}
									else{System.out.println("\nERROR: Inventory empty, please use ADD command first.");}
									break;
								}
								commandLine.close();
								throw new NoSuchElementException();
							}// Second argument invalid
							else{System.out.println("\nERROR: Max price invalid.");}
						}// First argument invalid
						else{System.out.println("\nERROR: Price range invalid.");}
						break;
					case "FEL":	// Filters list to only show electric cars
						if (!commandLine.hasNext()) {
							if (!vroom.isEmpty) {
								vroom.filterByElectric();
								System.out.println("\nInventory filtered by electric cars.");
							}
							else{System.out.println("\nERROR: Inventory empty, please use ADD command first.");}
							break;
						}
						commandLine.close();
						throw new NoSuchElementException();
					case "FAW": // Filters to only show AWD cars
						if (!commandLine.hasNext()) {
							if (!vroom.isEmpty) {
								vroom.filterByAWD();
								System.out.println("\nInventory filtered by AWD cars.");
							}
							else{System.out.println("\nERROR: Inventory empty, please use ADD command first.");}
							break;
						}
						commandLine.close();
						throw new NoSuchElementException();
					case "FCL":	// Clears all filters
						if (!commandLine.hasNext()) {
							if (!vroom.isEmpty) {
								vroom.FiltersClear();
								System.out.println("\nFilters cleared.");
							}
							else{ System.out.println("\nERROR: Inventory empty"); }
							break;
						}
						commandLine.close();
						throw new NoSuchElementException();
					// Commands not on switch will throw this exception
					default:
						commandLine.close();
						throw new NoSuchElementException();
					}
					commandLine.close();
					line = "";
				}
				// Catches any foreign command
				catch (NoSuchElementException NSEE) {
					System.out.println("\nERROR: '" + line + "' Not Recognized");
					line = "";
				}
				// Catches Index out of bounds exceptions
				catch (IndexOutOfBoundsException IOOBE) {
					System.out.println(IOOBE.getMessage());
				}
				// Catches illegal argument exceptions
				catch (IllegalArgumentException IAE) {
					System.out.println(IAE.getMessage());
				}
				// Catches all other exception
				catch (Exception excep) {
					System.out.println("\nERROR: " + excep);
				}
				System.out.print("\nEnter another command.");
			}
			input.close();
		}
	}
	/**
	 * Reads text file and converts into ArrayList<Car>
	 * @param filename
	 * @param cars (ArrayList)
	 */
	private static boolean readFile(String filename, ArrayList<Car> cars) throws FileNotFoundException {
		try {
			Scanner scan = new Scanner(new File(filename));
			ArrayList<Object> lineRead = new ArrayList<Object>(); // Array list to store data
			// Constants
			final String BATTERY_TYPE = "Li-Ion";
			final int NUM_WHEELS = 4;
			// Other variable initialized
			int modelInt;
			int powerInt;
			int rechargeTimeFile = 0;
			boolean awdVal;
			System.out.println("Loaded from File: " + filename);
			// While the file has more lines to read
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				Scanner lineScanner = new Scanner(line); // Creates a new scanner to read from line
				while (lineScanner.hasNext()) { //using while loop, add each piece of data in line into an array called lineRead
					String carData = lineScanner.next();
					lineRead.add(carData); //using arraylist gives access to pieces of line easily, no need to use string methods to seperate
				}
				lineScanner.close();
				/* 
				 * Extracts data from lineRead to make into Car object variables
				 */
				String brandData = (String)lineRead.get(0); //since first in each line is brand, brand is first in array list
				String colorData = (String)lineRead.get(1); //color second in line means color second in array list
				
				String modelData = (String)lineRead.get(2); //model needs to be converted from string back to int before added
				switch (modelData) {
				case "SEDAN":
					modelInt = Car.SEDAN;
					break;
				case "SUV":
					modelInt = Car.SUV;
					break;
				case "SPORTS":
					modelInt = Car.SPORTS;
					break;
				case "MINIVAN":
					modelInt = Car.MINIVAN;
					break;
				default: // Any invalid data values will throw an exception
					throw new IllegalArgumentException("\nERROR: Model not accepted");
				}
				String powerData = (String)lineRead.get(3);
				switch (powerData) {
				case "ELECTRIC_MOTOR":
					powerInt = Car.ELECTRIC_MOTOR;
					break;
				case "GAS_ENGINE":
					powerInt = Car.GAS_ENGINE;
					break;
				default: // Invalid data values here will throw exception
					throw new IllegalArgumentException("\nERROR: Can't convert to valid power type");
				}
				double safetyRatingFile = Double.parseDouble((String)lineRead.get(4));
				int maxRangeFile = Integer.parseInt((String)lineRead.get(5));
				String aWDFile = (String)lineRead.get(6);
				switch(aWDFile) {
					case "AWD":
						awdVal = true;
						break;
					case "2WD":
						awdVal = false;
						break;
					default: // Invalid data values will throw an exception
						throw new IllegalArgumentException("\nERROR: AWD value doesn't not valid");
				}
				int priceData = Integer.parseInt((String)lineRead.get(7));
				if (lineRead.size() == 9) {
					rechargeTimeFile = Integer.parseInt((String)lineRead.get(8));
					ElectricCar car = new ElectricCar(brandData, colorData, powerInt, NUM_WHEELS, modelInt, maxRangeFile, safetyRatingFile, priceData, awdVal, rechargeTimeFile, BATTERY_TYPE);	// Constructs an electric car
					cars.add(car); // Adds the car object to array list
				}
				else {
					Car car = new Car(brandData, colorData, powerInt, 4, modelInt, maxRangeFile, safetyRatingFile, priceData, awdVal);	// Constructs car object from data values
					cars.add(car); // Adds new car to array list
				}
				lineRead.clear(); // Clears arrayList to make car from next line of data
			}
			scan.close();
			return true;
		}
		catch (IllegalArgumentException IAE) { 	// Catches invalid data type or values
			System.out.println("\n" + IAE);
			return false;
		}
		catch (FileNotFoundException e) { // Catches invalid file name
			System.out.println("\nERROR: " + e + "\nPlease check the file location and try again!");
			return false;
		}
	}
}