package com.Maker.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Plan
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column( unique = true , length = 25)
	private String pName;

	private String price;

	private int maxUser;

	private String setOfFeatures;

//	@OneToMany(mappedBy = "plan" , cascade = CascadeType.ALL , orphanRemoval = true)
//	private List<ClinicPlan> clinicPlans;

	public Plan()
	{
	}


	public Plan(String planName, String price, int maxUser, String setOfFeatures) {
		this.pName = planName;
		this.price = price;
		this.maxUser = maxUser;
		this.setOfFeatures = setOfFeatures;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getMaxUser() {
		return maxUser;
	}

	public void setMaxUser(int maxUser) {
		this.maxUser = maxUser;
	}

	public String getSetOfFeatures() {
		return setOfFeatures;
	}

	public void setSetOfFeatures(String setOfFeatures) {
		this.setOfFeatures = setOfFeatures;
	}


}
