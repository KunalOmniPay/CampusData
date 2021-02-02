package com.mindree.service.impl;

import java.util.List;

import com.mindree.dao.EmployeeDao;
import com.mindree.dao.impl.EmployeeDaoImpl;
import com.mindree.entity.EmployeeData;
import com.mindree.exception.daoException.CampusDataDaoException;
import com.mindree.exception.serviceException.CampusDataServiceException;
import com.mindree.exception.serviceException.EmployeeServiceException;
import com.mindree.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private static EmployeeDao employeeDao=new EmployeeDaoImpl();
	@Override
	public String addEmployee(EmployeeData employee) throws CampusDataServiceException {
		String message="";
		try {
			message=employeeDao.addEmployee(employee);
		} catch (CampusDataDaoException e) {
			throw new EmployeeServiceException(e.getMessage());
		}
		return message;
	}
	@Override
	public String deleteEmployee(int id) throws CampusDataServiceException {
		String message="";
		try {
			message=employeeDao.deleteEmployee(id);
		} catch (CampusDataDaoException e) {
			throw new EmployeeServiceException(e.getMessage());
		}
		return message;
	}
	@Override
	public String updateEmployee(int id, String phoneNumber) throws CampusDataServiceException {
		String message="";
		try {
			message=employeeDao.updateEmployee(id, phoneNumber);
		} catch (CampusDataDaoException e) {
			throw new EmployeeServiceException();
		}
		return message;
	}
	@Override
	public List<EmployeeData> fetchEmployeeData(String trackName) throws CampusDataServiceException {
		List<EmployeeData> employeeData=null;
		try {
			employeeData=employeeDao.fetchEmployee(trackName);
		} catch (CampusDataDaoException e) {
			throw new EmployeeServiceException(e.getMessage());
		}
		return employeeData;
		
	}

	
}
