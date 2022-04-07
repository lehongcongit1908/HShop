package com.eshop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Customers")
public class Customer implements Serializable {
	@Id
	String id;
	String password;
	String fullname;
	String email;
	String photo;
	boolean activated = false;
	boolean admin = false;
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	List<Order> orders;
}
