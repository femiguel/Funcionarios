package application;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.outsourceEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		
		System.out.println("Enter the number of Employess: ");
		int n = sc.nextInt();
		
		for (int i=1; i<n+1;i++) {
			System.out.print("Enter Eployee #"+i+" data: ");
			System.out.print("Outsourced? (y/n)");
			char ch = sc.next().charAt(0);
			System.out.print("Enter name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			if(ch == 'y'||ch == 'Y') {
				System.out.println("Enter additional Charge: ");
				double additionalCharge = sc.nextDouble();
				list.add(new outsourceEmployee(name, hours, valuePerHour, additionalCharge));
			}
			else {
				list.add(new Employee(name, hours, valuePerHour));
			}
		}
		System.out.println();
		System.out.println("Payments:");
		for (Employee emp : list) {
			System.out.println(emp.getName()+" - $"+ String.format("%.2f", emp.payment()));
		}
		
		sc.close();
	}

}
