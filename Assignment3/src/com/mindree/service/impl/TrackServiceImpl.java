package com.mindree.service.impl;

import com.mindree.dao.TrackDao;
import com.mindree.dao.impl.TrackDaoImpl;
import com.mindree.entity.Track;
import com.mindree.exception.daoException.CampusDataDaoException;
import com.mindree.exception.serviceException.CampusDataServiceException;
import com.mindree.exception.serviceException.TrackServiceException;
import com.mindree.service.TrackService;

public class TrackServiceImpl implements TrackService{
	private static TrackDao trackDao=new TrackDaoImpl(); 

	@Override
	public int getTrackEmployeeCount(String name) throws CampusDataServiceException {
		int count=0;
		try {
		count = trackDao.getTrackEmployeeCount(name);
		} catch (CampusDataDaoException e) {
			throw new TrackServiceException(e.getMessage());
		}
		return count;
	}

	@Override
	public boolean isTrackPresent(String trackName) throws CampusDataServiceException {
		boolean isPresent;
		try {
			isPresent = trackDao.isPresent(trackName);
		} catch (CampusDataDaoException e) {
			throw new TrackServiceException(e.getMessage());
		}
		return isPresent;
	}

	@Override
	public String updateTrackCount(String trackName) throws CampusDataServiceException {
		String message="";
		try {
			message=trackDao.updateTrackCount(trackName);
		} catch (CampusDataDaoException e) {
			throw new TrackServiceException(e.getMessage());
		}
		return message;
	}

	@Override
	public String insertTrack(Track track) throws CampusDataServiceException {
		
		String message="";
		try {
			message=trackDao.insertTrack(track);
		} catch (CampusDataDaoException e) {
			throw new TrackServiceException(e.getMessage());
		}
		return message;
		
	}

}
