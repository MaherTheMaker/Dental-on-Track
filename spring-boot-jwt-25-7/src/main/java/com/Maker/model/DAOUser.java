package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.security.AllPermission;
import java.util.List;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;


	@OneToMany(mappedBy = "daoUser", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> transactionList;


	@ManyToOne
	@JoinColumn(name = "safe_id")
	@JsonIgnore
	private MoneySafe safe;

	@OneToMany(mappedBy = "daoUser",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Expenses> expenses;

	@OneToMany(mappedBy = "daoUser",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Recep> receps;

	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String fullName;
	private String number;
	private String email;
	private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
}