package com.mphasis.training.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value="SA")
@PrimaryKeyJoinColumn(name="acntnum")
public class SavingsAccount extends Account {
	
	private long adhrnum;

	public long getAdhrnum() {
		return adhrnum;
	}

	public void setAdhrnum(long adhrnum) {
		this.adhrnum = adhrnum;
	}

	@Override
	public String toString() {
		return "SavingsAccount [adhrnum=" + adhrnum + "]";
	}
	
	
	

}
