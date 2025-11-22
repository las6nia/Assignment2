package assignment2;
import java.util.Scanner;



public class Main {
	static Scanner input = new Scanner(System.in);
	

	public static void main(String[] args) { //start of main method
		char customerType; // work on variables
		double fee, fee1;
	

		displayMenu();
		customerType = input.next().toLowerCase().charAt(0);

		while (customerType != 'r' && customerType != 'b') {
		    System.out.println("Enter a valid option");
		    displayMenu();  
		    customerType = input.next().toLowerCase().charAt(0);
		    
		    if (customerType =='r') {
		    	System.out.print("residential: ");
				System.out.print(residentialBill());// check bill if anything goes wrong

		    }
		    else {
		    	System.out.print("Business");
		    	fee1 = businessBill();
		    	System.out.print(fee1); //check what's wrong
		    }
		}


	}//end of first method
	
// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-LUIS' CODE-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
	
	public static void displayMenu() { //main display
		System.out.print("Enter customer type: R, r (Residential) or B, b (Business): \n");
		
	}
	

	public static void menuDisplay() { //options
		char userChoice;
		System.out.println("I - Enroll in our installment plan");
		System.out.println("V - View change in consumption: Compare your current bill with your\nprevious one"); //Enter John's code inside if choice  == V!!!!!
		System.out.println("E - Exit");
		userChoice = input.next().toLowerCase().charAt(0);
		
		while (userChoice != 'e') {
			if (userChoice =='i') {
//				installmentCalculator(); //Mark's code - look & fix in my method
				
			}
			else { // lra - do else if (userChoice =='v') instead if any issues but shouldn't due to while loop
				System.out.print("please enter the current amount due:");
				int NewAmount = input.nextInt();

				ChangeInConsumption(NewAmount);

				input.close();
			}
		}
	}
// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-MARK'S CODE-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
	
	 public static void installmentCalculator(double billAmount) {

	        System.out.print("Enter the number of the required Installment (2, 3, or 4):\n");
	        int numInstallments = input.nextInt();

	        double interestRate = 0.0;

	        if (numInstallments == 2) {
	            interestRate = 0.0535;
	        } else if (numInstallments == 3) {
	            interestRate = 0.055;
	        } else if (numInstallments == 4) {
	            interestRate = 0.0575;
	        }

	        double totalWithInterest = billAmount * (1.0 + interestRate);
	        double eachInstallment = totalWithInterest / numInstallments;

	      
	        System.out.printf("With %d installment your bill of $%.2f will be worth $%.2f\n",numInstallments, billAmount, totalWithInterest);
	        System.out.printf("Each installment will be worth $%.2f\n", eachInstallment);
	    }
	
// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-LIN'S CODE-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
	public static double residentialBill(){ //start of residential - Lin's code
		double kwh;
		double fee;
		
		
		System.out.print("Welcome Residential Customer,\n Enter the total usage KiloWatt Hours (KWH): \n");
		kwh = input.nextDouble();
		
		fee = kwh * 0.12 + 8.07;
		fee = fee + fee * 0.05;
		System.out.printf("Amount due: $%.2f\n", fee);
		System.out.printf("30 Billing Days\n");
		System.out.printf("Average Cost Per Day = $%.2f", fee/30);
		
		return fee;
	} //end of residential
	public static double businessBill() {// Business Bill - Lin - start of business
		double KWH;
		double fee;
		int  premiumChannels;
		
		System.out.print("Welcome Business Customer,\nEnter the total usage KiloWatt Hours (KWH): \n");
		KWH = input.nextDouble();
		System.out.print("Enter the number of premium channels used: \n");
		premiumChannels = input.nextInt();
		
		if (KWH <= 1200)
		{
			fee = KWH * 0.17 + 47 * premiumChannels + 17.07;
		}
		
		else
		{
			fee = 204 + (KWH-1200) * 0.12 + 47 * premiumChannels + 17.07;
		}
		fee = fee + fee * 0.08;
		System.out.printf("Amount due: $%.2f\n", fee);
		System.out.printf("30 Billing Days\n");
		System.out.printf("Average Cost Per Day = $%.2f", fee/30); //check to get average? do we divide by channels (amount) or 30 days for the average?
		
		return fee;
	} //end of business bill
	
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-JOHN'S CODE-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
	public static void ChangeInConsumption(int NewAmount) {

		Scanner input = new Scanner(System.in);
		double change;
		System.out.print("Please enter your amount due one month ago:");
		int LastAmount = input.nextInt();
		//Last Amount > New Amount:
		//- The change in consumption = (Last Amount - New Amount) / Last Amount
		//- It’s a decreasing change
		if(LastAmount > NewAmount)
		{change =(double) (LastAmount - NewAmount) / LastAmount;
		System.out.println("It’s a decreasing change");
		}


		//New Amount > Last Amount:
		//		- The change in consumption = (New Amount - Last Amount) / Last Amount
		//		- It’s an increasing change
		else if(LastAmount < NewAmount)
		{change =(double) (NewAmount - LastAmount) / LastAmount;
		System.out.println("It’s an increasing change");
		}


		//New Amount = Last Amount:
		//- The change in consumption = 0
		//	- There is no change in the consumption
		else
		{change = 0;
		System.out.println("There is no change in the consumption");
		}	
		System.out.printf("the change in consumption is %.2f%%", change*100);
	}
	
	
	
	
	
}//end of Main Main
