package ua.lviv.lgs.domain;

public class User {

	private Integer id;
	private String firstName;
	private String lastName;
	private String emaill;
	private String role;
	
	public User(String firstName, String lastName, String emaill, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emaill = emaill;
		this.role = role;
	}
	
	public User(Integer id, String firstName, String lastName, String emaill, String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emaill = emaill;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmaill() {
		return emaill;
	}

	public void setEmaill(String emaill) {
		this.emaill = emaill;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emaill=" + emaill
				+ ", role=" + role + "]";
	}
	
	
	
	
}
