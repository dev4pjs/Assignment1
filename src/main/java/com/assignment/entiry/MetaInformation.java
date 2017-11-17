package com.assignment.entiry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class MetaInformation {
	
	
	
	@Id 
	private int metaInfoId;
	
	@Column(name="field1")
	private String metaInfoField1;
	
	@Column(name="field2")
	private String metaInfoField2;
	
	@Column(name="field3")
	private String metaInfoField3;
	
	
	
	
	public MetaInformation() {
		super();
	}
	public MetaInformation(int id, String metaInfoField1, String metaInfoField2, String metaInfoField3) {
		super();
		this.metaInfoId = id;
		this.metaInfoField1 = metaInfoField1;
		this.metaInfoField2 = metaInfoField2;
		this.metaInfoField3 = metaInfoField3;
	}
	public int getMetaInfoId() {
		return metaInfoId;
	}
	public void setMetaInfoId(int metaInfoId) {
		this.metaInfoId = metaInfoId;
	}
	public String getMetaInfoField1() {
		return metaInfoField1;
	}
	public void setMetaInfoField1(String metaInfoField1) {
		this.metaInfoField1 = metaInfoField1;
	}
	public String getMetaInfoField2() {
		return metaInfoField2;
	}
	public void setMetaInfoField2(String metaInfoField2) {
		this.metaInfoField2 = metaInfoField2;
	}
	public String getMetaInfoField3() {
		return metaInfoField3;
	}
	public void setMetaInfoField3(String metaInfoField3) {
		this.metaInfoField3 = metaInfoField3;
	}
}
