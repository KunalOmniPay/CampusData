package com.mindree.entity;

public class EmployeeData {
	private int id;
	private String name, mobileNo, role;
	Track track;

	public EmployeeData(int id, String name, String mobileNo, String role, Track track) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.role = role;
		this.track = track;
	}
	
	public EmployeeData() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@Override
	public String toString() {
		return "EmployeeData [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", role=" + role + ", track="
				+ track.getTrackName() + "number of minds = "+track.getCountOfMinds()+ "]";
	}

	
	

}
