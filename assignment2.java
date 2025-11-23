package assignment2;

import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) { // start of main method
		char customerType;
		double fee;

		displayMenu();
		customerType = input.next().toLowerCase().charAt(0);
//Start of the while loop
		while (customerType != 'r' && customerType != 'b') {
			System.out.println("Enter a valid option");
			displayMenu();
			customerType = input.next().toLowerCase().charAt(0);
		}

		// residential
		if (customerType == 'r') {
			fee = residentialBill();
		}
		// business
		else {
			fee = businessBill();
		}

		menuDisplay(fee); 

		System.out.println("Goodbye."); //
	}// end of main

// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-LUIS' CODE-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-


	public static void displayMenu() { // main display 
		System.out.print("Enter customer type: R, r (Residential) or B, b (Business): \n");
	}

	public static void menuDisplay(double billAmount) { // options
		char userChoice;

		System.out.println("Please select an option: ");
		System.out.println("I - Enroll in our installment plan");
		System.out.println("V - View change in consumption: Compare your current bill with your\nprevious one");
		System.out.println("E - Exit");
		userChoice = input.next().toLowerCase().charAt(0);

		while (userChoice != 'e') {

			if (userChoice == 'i') {
				// Installment Options 
				char paymentPlanSelection;
				System.out.println(".......................................");
				System.out.println(
						"If you do not want to make a onetime payment, we have an easy\ninstallment plan for you. This is an interest charge plan.");
				System.out.print("Sign up for the Installment Payment Plan (y/n)? \n");
				paymentPlanSelection = input.next().toLowerCase().charAt(0);

				if (paymentPlanSelection == 'y') {
					installmentCalculator(billAmount);
				}
			}

			else if (userChoice == 'v') {
				// -- Change in consumption --
				System.out.print("Enter the amount due of your previous bill: \n");
				double lastAmount = input.nextDouble();
				ChangeInConsumption(billAmount, lastAmount);
			}

			// Ask again
			System.out.println("Please select an option: ");
			System.out.println("I - Enroll in our installment plan");
			System.out.println("V - View change in consumption: Compare your current bill with your\nprevious one");
			System.out.println("E - Exit");
			userChoice = input.next().toLowerCase().charAt(0);
		}
	}

// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-MARK'S CODE-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-

	public static void installmentCalculator(double billAmount) { //start of installmentCalculator - Mark's code
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

		System.out.printf("With %d installment your bill of $%.2f will be worth $%.2f.\n", numInstallments, billAmount, totalWithInterest);
		System.out.printf("Each installment will be worth $%.2f\n\n", eachInstallment);
	} //end of installmentCalculator


// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-LIN'S CODE-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	-
	// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-

	public static double residentialBill() { //start of residential - Lin's code
		double kwh;
		double fee;

		System.out.print("\nWelcome Residential Customer,\nEnter the total usage KiloWatt Hours (KWH): \n");
		kwh = input.nextDouble();

		fee = kwh * 0.12 + 8.07;
		fee = fee + fee * 0.05;

		System.out.printf("\nAmount due: $%.2f\n", fee);
		System.out.printf("30 Billing Days\n");
		System.out.printf("Average Cost Per Day = $%.2f\n\n", (fee / 30));

		return fee;
	}//end of residential

	public static double businessBill() { // Business Bill - Lin - start of business
		double KWH;
		double fee;
		int premiumChannels;

		System.out.print("\nWelcome Business Customer,\nEnter the total usage KiloWatt Hours (KWH): \n");
		KWH = input.nextDouble();
		System.out.print("Enter the number of premium channels used: \n");
		premiumChannels = input.nextInt();

		if (KWH <= 1200) {
			fee = KWH * 0.17 + 47 * premiumChannels + 17.07;
		} else {
			fee = 204 + (KWH - 1200) * 0.12 + 47 * premiumChannels + 17.07;
		}

		fee = fee + fee * 0.08;

		System.out.printf("\nAmount due: $%.2f\n", fee);
		System.out.printf("30 Billing Days\n");
		System.out.printf("Average Cost Per Day = $%.2f\n\n", fee / 30);

		return fee;
	}//end of business bill

// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-
// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-JOHN'S CODE-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	-
// 	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-	-	-	-	-	-	-	--	-	-	-	-	-	-	-

	public static void ChangeInConsumption(double newAmount, double lastAmount) { //calculation - john's code

		double change;
		if (lastAmount > newAmount) {
			change = (lastAmount - newAmount) / lastAmount;
			System.out.printf(
					"The change in consumption is decreasing by %.2f%%, when\ncomparing with previous due\n\n",
					change * 100);
		} else if (lastAmount < newAmount) {
			change = (newAmount - lastAmount) / lastAmount;
			System.out.printf("The change in consumption is increasing by %.2f%%, when comparing with previous due\n\n",
					change * 100);
		} else {
			System.out.println("There is no change in the consumption\n");
		}
	}

} // end of Main
