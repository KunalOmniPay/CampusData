package com.mindree.service;

import com.mindree.entity.Track;
import com.mindree.exception.serviceException.CampusDataServiceException;

public interface TrackService {

	int getTrackEmployeeCount(String name) throws CampusDataServiceException;

	boolean isTrackPresent(String trackName) throws CampusDataServiceException;

	String updateTrackCount(String trackName) throws CampusDataServiceException;

	String insertTrack(Track track) throws CampusDataServiceException;

}
