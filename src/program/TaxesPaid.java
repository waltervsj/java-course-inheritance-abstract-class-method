package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entity.Company;
import entity.Individual;
import entity.Payer;

public class TaxesPaid {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Payer> payers = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int taxPayersQuantity = sc.nextInt();
				
		for (int i = 0; i < taxPayersQuantity; i++) {
			System.out.print("Individual or company (i/c)? ");
			char payerType = sc.next().charAt(0);
		
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			
			if (payerType == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				payers.add(new Individual(name, anualIncome, healthExpenditures));
				
			} else {
				System.out.print("Number of employees: ");
				Integer numberOfEmployees = sc.nextInt();
				payers.add(new Company(name, anualIncome, numberOfEmployees));
			}			
		}
		
		System.out.println("TAXES PAID: ");
		Double totalPaid = 0.00;
		for(Payer payer : payers) {
			Double taxPaid = payer.taxPaid();
			totalPaid += taxPaid;
			System.out.println(payer.getName() + ": $" + String.format("%.2f", taxPaid));
		}
		
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", totalPaid));
		sc.close();
	}

}
