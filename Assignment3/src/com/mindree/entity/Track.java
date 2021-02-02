package com.mindree.entity;

public class Track {
	private String trackName;
	private int countOfMinds;

	public Track(String trackName, int countOfMinds) {
		super();
		this.trackName = trackName;
		this.countOfMinds = countOfMinds;
	}

	public Track() {
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public int getCountOfMinds() {
		return countOfMinds;
	}

	public void setCountOfMinds(int countOfMinds) {
		this.countOfMinds = countOfMinds;
	}

}
