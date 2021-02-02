package com.mindree.service;

import java.util.List;

import com.mindree.entity.EmployeeData;
import com.mindree.exception.serviceException.CampusDataServiceException;

public interface EmployeeService {

	String addEmployee(EmployeeData employeeData) throws CampusDataServiceException;

	String deleteEmployee(int id) throws CampusDataServiceException;

	String updateEmployee(int id, String phoneNumber) throws CampusDataServiceException;

	List<EmployeeData> fetchEmployeeData(String trackName) throws CampusDataServiceException;

}
