package com.mindree.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindree.dao.EmployeeDao;
import com.mindree.entity.EmployeeData;
import com.mindree.entity.Track;
import com.mindree.exception.daoException.CampusDataDaoException;
import com.mindree.exception.daoException.ConnectionFailedException;
import com.mindree.exception.daoException.EmployeeDaoException;

import com.mindree.utility.JDBCconnection;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addEmployee(EmployeeData employee) throws CampusDataDaoException {
		String message="";
		Connection con=null;
		try {
		con=JDBCconnection.getConnection();
		}
		catch(ConnectionFailedException e)
		{
			throw new EmployeeDaoException(e.getMessage());
			
		}
		String query="insert into mindtreedata values(?,?,?,?,?,?)";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1,employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getTrack().getTrackName());
			ps.setInt(4, employee.getTrack().getCountOfMinds());
			ps.setString(5, employee.getMobileNo());
			ps.setString(6, employee.getRole());
			ps.executeUpdate();
			message ="Employees details updated successfully";
			
		} catch (SQLException e) {
			throw new EmployeeDaoException(e.getMessage());
		}
		return message;
	}

	@Override
	public String deleteEmployee(int id) throws CampusDataDaoException {
		String message="";
		Connection con=null;
		try {
		con=JDBCconnection.getConnection();
		}
		catch(ConnectionFailedException e)
		{
			throw new EmployeeDaoException(e.getMessage());
			
		}
		String query="delete from mindtreedata where id=?";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			message ="Employees deleted successfully";
			
		} catch (SQLException e) {
			throw new EmployeeDaoException(e.getMessage());
		}
		return message;
	}

	@Override
	public String updateEmployee(int id, String phoneNumber) throws CampusDataDaoException {
		String message="";
		Connection con=null;
		try {
		con=JDBCconnection.getConnection();
		}
		catch(ConnectionFailedException e)
		{
			throw new EmployeeDaoException(e.getMessage());
			
		}
		String query="update mindtreedata set phone_number=? where id=?";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, phoneNumber);
			ps.setInt(2, id);
			ps.executeUpdate();
			message ="Employees updated successfully";
			
		} catch (SQLException e) {
			throw new EmployeeDaoException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<EmployeeData> fetchEmployee(String trackName) throws CampusDataDaoException {
		String message="";
		List<EmployeeData> employeeData=new ArrayList<>();
		Connection con=null;
		try {
		con=JDBCconnection.getConnection();
		}
		catch(ConnectionFailedException e)
		{
			throw new EmployeeDaoException(e.getMessage());
			
		}
		String query="select * from mindtreedata where track=?";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, trackName);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{	Track track = new Track(rs.getString(3),rs.getInt(4));
				EmployeeData employee=new EmployeeData(rs.getInt(1), rs.getString(1),rs.getString(5),rs.getString(6), track);
				employeeData.add(employee);
			}
			message ="Employees deleted successfully";
			
		} catch (SQLException e) {
			throw new EmployeeDaoException(e.getMessage());
		}
		return employeeData;
	}

	}

	
	

