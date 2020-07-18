package com.mphasis.training.entities;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="accounttype", discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue(value="account")

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class Account {
	
	@Id
	private int acntnum;
	
	private double balance;
	
	@Column(length = 10)
	private String acc_holder_name;

	public int getAcntnum() {
		return acntnum;
	}

	public void setAcntnum(int acntnum) {
		this.acntnum = acntnum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAcc_holder_name() {
		return acc_holder_name;
	}

	public void setAcc_holder_name(String acc_holder_name) {
		this.acc_holder_name = acc_holder_name;
	}

	@Override
	public String toString() {
		return "Account [acntnum=" + acntnum + ", balance=" + balance + ", acc_holder_name=" + acc_holder_name + "]";
	}
	
	

}
