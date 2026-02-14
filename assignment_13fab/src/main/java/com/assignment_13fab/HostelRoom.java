package com.assignment_13fab;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HostelRoom {

	@Id
	private int roomId;
	private int roomNumber;
	private String blockName;
	private int floorName;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public int getFloorName() {
		return floorName;
	}
	public void setFloorName(int floorName) {
		this.floorName = floorName;
	}
	
}
