package com.mindree.client;

import java.util.List;
import java.util.Scanner;

import com.mindree.entity.EmployeeData;
import com.mindree.entity.Track;
import com.mindree.exception.serviceException.CampusDataServiceException;
import com.mindree.service.EmployeeService;
import com.mindree.service.TrackService;
import com.mindree.service.impl.EmployeeServiceImpl;
import com.mindree.service.impl.TrackServiceImpl;

public class EmployeeApp {

	private static Scanner sc = new Scanner(System.in);
	private static EmployeeService employeeService = new EmployeeServiceImpl();
	private static TrackService trackService = new TrackServiceImpl();

	public static void main(String[] args) {
		boolean exitMenu = false;
		do {

			displayMenu();
			int choice = sc.nextInt();
			sc.nextLine();
			String message = "";
			int id;
			switch (choice) {
			case 1:
				
				try {
					message = employeeService.addEmployee(getEmployeeData());
				} catch (CampusDataServiceException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(message);
				break;
			case 2:
				System.out.println("Enter employee id");
				id=sc.nextInt();
				try {
					message=employeeService.deleteEmployee(id);
				} catch (CampusDataServiceException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(message);
				break;
			case 3:
				System.out.println("Enter Employee id");
				id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter phone number");
				String phone=sc.nextLine();
				try {
					message=employeeService.updateEmployee(id, phone);
				} catch (CampusDataServiceException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(message);
				break;
			case 4:
				System.out.println("Enter track name");
				String trackName=sc.nextLine();
				try {
					List<EmployeeData> employeeData = employeeService.fetchEmployeeData(trackName);
					displayEmployee(employeeData);
				} catch (CampusDataServiceException e) {
					System.out.println(e.getMessage());
				}
				
			}
		} while (!exitMenu);

	}

	private static void displayEmployee(List<EmployeeData> employeeData) {
		for(EmployeeData emp: employeeData)
		{
			System.out.println(emp.toString());
		}
		
	}

	private static EmployeeData getEmployeeData() {
		int count=1;
		boolean present=false;
		System.out.println("Enter Id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee name");
		String empName = sc.nextLine();
		System.out.println("Enter track name");
		String trackName = sc.nextLine();
		try {
			present = trackService.isTrackPresent(trackName);
		} catch (CampusDataServiceException e) {
			System.out.println(e.getMessage());
		}
		if(present)
		{
			try {
				String message=trackService.updateTrackCount(trackName);
				count = trackService.getTrackEmployeeCount(trackName);
			} catch (CampusDataServiceException e) {
				System.out.println(e.getMessage());
			}
		}
		else
		{
			Track track = new Track(trackName,1);
			try {
				String message=trackService.insertTrack(track);
			} catch (CampusDataServiceException e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("Enter role of employee(Lead/mind)");
		String role = sc.nextLine();
		System.out.println("PhoneNumber");
		String number = sc.nextLine();
		Track track=new Track(trackName, count);
		EmployeeData employee=new EmployeeData(id, empName, number, role , track);
		return employee;
		
	}

	public static void displayMenu() {
		System.out.println("1.Add Employee");
		System.out.println("2.Delete Employee");
		System.out.println("3.Update PhoneNumber");
		System.out.println("4.Show all campus mind under specific track");
	}
}
