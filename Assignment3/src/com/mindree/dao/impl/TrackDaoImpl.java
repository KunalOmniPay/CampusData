package com.mindree.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindree.dao.TrackDao;
import com.mindree.entity.Track;
import com.mindree.exception.daoException.CampusDataDaoException;
import com.mindree.exception.daoException.ConnectionFailedException;
import com.mindree.exception.daoException.TrackDaoException;
import com.mindree.utility.JDBCconnection;

public class TrackDaoImpl implements TrackDao {

	@Override
	public boolean isPresent(String trackName) throws CampusDataDaoException {
		Connection con = null;

		try {
			con = JDBCconnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new TrackDaoException(e.getMessage());
		}
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="Select * from track where track_name=?";
		try {
		
			ps=con.prepareStatement(query);
			ps.setString(1, trackName);
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		}
		catch(SQLException e)
		{
			throw new TrackDaoException(e.getMessage());
		}
		

		return false;
	}

	@Override
	public String updateTrackCount(String trackName) throws CampusDataDaoException {
		String message="";
		Connection con=null;
		try {
		con=JDBCconnection.getConnection();
		}
		catch(ConnectionFailedException e)
		{
			throw new TrackDaoException(e.getMessage());
			
		}
		String query="select count_of_minds from track where track_name=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, trackName);
			rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			ps=con.prepareStatement("update track set count_of_minds=? where track_name=?");
			ps.setInt(1, count+1);
			ps.setString(2,trackName);
			ps.executeUpdate();
			ps=con.prepareStatement("update mindtreedata set no_of_minds_in_track=? where track=?");
			ps.setInt(1, count+1);
			ps.setString(2,trackName);
			ps.executeUpdate();
			message ="track details updated successfully";
			
		} catch (SQLException e) {
			throw new TrackDaoException(e.getMessage());
		}
		return message;
		
	}

	@Override
	public String insertTrack(Track track) throws CampusDataDaoException {
		
		String message="";
		Connection con=null;
		try {
		con=JDBCconnection.getConnection();
		}
		catch(ConnectionFailedException e)
		{
			throw new TrackDaoException(e.getMessage());
			
		}
		String query="insert into Track values(?,?)";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,track.getTrackName());
			ps.setInt(2, 1);
			ps.executeUpdate();
			message ="track details updated successfully";
			
		} catch (SQLException e) {
			throw new TrackDaoException(e.getMessage());
		}
		return message;
		
	}

	@Override
	public int getTrackEmployeeCount(String name) throws CampusDataDaoException {
	
		String message="";
		Connection con=null;
		try {
		con=JDBCconnection.getConnection();
		}
		catch(ConnectionFailedException e)
		{
			throw new TrackDaoException(e.getMessage());
			
		}
		String query="select count_of_minds from track where track_name=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			rs=ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			
			
		} catch (SQLException e) {
			throw new TrackDaoException(e.getMessage());
		}
		return count;
		
	}

}
