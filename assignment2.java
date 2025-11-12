package assignment2;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//calculating a customers bill:
		//one for residential and the other for business
//Both need methods, one called ResidentialBill() and the other called BusinessBill()
		//When called, this returns the value to the main body

		
		//presenting with main menu - after the balance shows, re-show the menu
		menuDisplay();
		
		char customerType = Character.toLowerCase(input.next().charAt(0));
		
		while (customerType != 'r' && customerType != 'b') 
		{	
			switch (customerType) {
			case 'r':
				//Enter residential method here
				
				double kiloWattHours = input.nextDouble();
				residentialCustomer(kiloWattHours);
				break;
			
			case 'b':
				//Enter business method here
				break;
			}
		}
		
	}
//menu settings
	public static void menuDisplay() {
		System.out.print("Enter customer type: R, r (Residential) or B, b(Business):\n");
	}//end of main menu
	
public static double residentialCustomer(double kiloWattHours) { //residential Customer 
	System.out.println("Enter the total usage KiloWatt Hours (KWH): \n");
	kiloWattHours += kiloWattHours; 
	
	//Math goes here
	
	return kiloWattHours; //keep this to return balance
}
	
	
	
}
