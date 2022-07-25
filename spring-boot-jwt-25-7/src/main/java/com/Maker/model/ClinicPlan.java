//package com.Maker.model;
//
//import org.hibernate.validator.constraints.UniqueElements;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//
//
//public class ClinicPlan implements Serializable
//{
//
//	private int id;
//
//
//	private Clinic clinic;
//
//
//	private Plan plan;
//
//
//	private Date paymentDate;
//
//
//
//	private int paymentId ;
//
//
//	private Date activeDate;
//
//	public ClinicPlan() {
//	}
//
//	public ClinicPlan(Clinic clinic, Plan plan, Date paymentDate, int paymentId, Date activeDate) {
//		this.clinic = clinic;
//		this.plan = plan;
//		this.paymentDate = paymentDate;
//		this.paymentId = paymentId;
//		this.activeDate = activeDate;
//	}
//
//	public int getId()
//	{
//		return id;
//	}
//
//	public void setId(int id)
//	{
//		this.id = id;
//	}
//
//	public Clinic getClinic()
//	{
//		return clinic;
//	}
//
//	public void setClinic(Clinic clinic)
//	{
//		this.clinic = clinic;
//	}
//
//	public Plan getPlan()
//	{
//		return plan;
//	}
//
//	public void setPlan(Plan plan)
//	{
//		this.plan = plan;
//	}
//
//	public Date getPaymentDate() {
//		return paymentDate;
//	}
//
//	public void setPaymentDate(Date paymentDate) {
//		this.paymentDate = paymentDate;
//	}
//
//	public int getPaymentId() {
//		return paymentId;
//	}
//
//	public void setPaymentId(int paymentId) {
//		this.paymentId = paymentId;
//	}
//
//	public Date getActiveDate() {
//		return activeDate;
//	}
//
//	public void setActiveDate(Date activeDate) {
//		this.activeDate = activeDate;
//	}
//}
