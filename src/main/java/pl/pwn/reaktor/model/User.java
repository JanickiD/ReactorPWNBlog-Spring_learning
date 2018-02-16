package pl.pwn.reaktor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true)
	private String email;
	
	private String pass;
	
	private String name;
	
	private String lastName;
	
	private boolean active;
	
	@OneToOne
	private Role role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User(long id, String email, String pass, String name, String lastName, boolean active, Role role) {
		super();
		this.id = id;
		this.email = email;
		this.pass = pass;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.role = role;
	}

	public User() {
		super();
	}

	public User(String email, String pass, String name, String lastName, boolean active, Role role) {
		super();
		this.email = email;
		this.pass = pass;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", pass=" + pass + ", name=" + name + ", lastName=" + lastName
				+ ", active=" + active + ", role=" + role + "]";
	}
	
	

}
