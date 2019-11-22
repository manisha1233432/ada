package com.cg.project.bean;

public class BusinessSegment {

	private String Bus_Seg_Id;
	private String Bus_Seg_Name;

	public BusinessSegment(String bus_Seg_Id, String bus_Seg_Name) {
		super();
		Bus_Seg_Id = bus_Seg_Id;
		Bus_Seg_Name = bus_Seg_Name;
	}

	public BusinessSegment() {
		super();

	}

	public String getBus_Seg_Id() {
		return Bus_Seg_Id;
	}

	public void setBus_Seg_Id(String bus_Seg_Id) {
		Bus_Seg_Id = bus_Seg_Id;
	}

	public String getBus_Seg_Name() {
		return Bus_Seg_Name;
	}

	public void setBus_Seg_Name(String bus_Seg_Name) {
		Bus_Seg_Name = bus_Seg_Name;
	}

}
