package com.mindree.dao;

import com.mindree.entity.Track;
import com.mindree.exception.daoException.CampusDataDaoException;

public interface TrackDao {

	boolean isPresent(String trackName) throws CampusDataDaoException;

	String updateTrackCount(String trackName) throws CampusDataDaoException;

	String insertTrack(Track track) throws CampusDataDaoException;

	int getTrackEmployeeCount(String name) throws CampusDataDaoException;
	

}
