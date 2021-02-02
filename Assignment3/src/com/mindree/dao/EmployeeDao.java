package com.mindree.dao;

import java.util.List;

import com.mindree.entity.EmployeeData;
import com.mindree.exception.daoException.CampusDataDaoException;

public interface EmployeeDao {

	String addEmployee(EmployeeData employee) throws CampusDataDaoException;

	String deleteEmployee(int id )throws CampusDataDaoException;

	String updateEmployee(int id, String phoneNumber) throws CampusDataDaoException;

	List<EmployeeData> fetchEmployee(String trackName) throws CampusDataDaoException;

}
