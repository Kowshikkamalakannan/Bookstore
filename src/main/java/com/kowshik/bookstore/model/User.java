package com.kowshik.bookstore.model;

//import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Shop_name")
	private String shopName;

	private String email;

	private String phonenumber;
	
	private String password;

	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
		            name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id", referencedColumnName = "id"))
				
	private Collection<Role> roles;
	

	// @ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
	// private Collection<Books> book=new ArrayList<>();
	
	public User(String email) {
		this.email = email;
	}

	public User() {
		
	}
	  
	public User(String shopName, String email, String password,String phonenumber, Collection<Role> roles) {
		super();
		this.shopName = shopName;
		this.email = email;
		this.password = password;
		this.phonenumber=phonenumber;
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	// public Collection<Books> getBook() {
	// 	return book;
	// }

	// public void setBook(Collection<Books> book) {
	// 	this.book = book;
	// }


	

}